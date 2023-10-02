import pandas as pd
from elasticsearch import Elasticsearch, helpers
import os

# Retrieve the Elasticsearch host and API key from environment variables
elasticsearch_host = os.environ.get("ELASTICSEARCH_HOST")
elasticsearch_api_key = os.environ.get("ELASTICSEARCH_API_KEY")
elasticsearch_index = os.environ.get("INDEX_NAME")
csv_file_path = os.environ.get("CSV_FILE_PATH")

# Check if the required environment variables are set
if not elasticsearch_host or not elasticsearch_api_key:
    raise ValueError("ELASTICSEARCH_HOST and ELASTICSEARCH_API_KEY environment variables must be set.")

# Initialize Elasticsearch client
es = Elasticsearch(hosts=elasticsearch_host,
                   api_key=elasticsearch_api_key)


# Define the index mapping 
index_mapping = {
    "mappings": {
        "properties": {
            "Timestamp": {
                "type": "text"
            },
            "Age": {"type": "text"},
            "Industry": {"type": "keyword"},
            "JobTitle": {"type": "text"},
            "AnnualSalary": {"type": "double"},
            "Currency": {"type": "keyword"},
            "Location": {"type": "keyword"},
            "WorkExperience": {"type": "text"},
            "AdditionalContext": {"type": "text"},
            "OtherCurrency": {"type": "keyword"}
        }
    }
}

# Create the Elasticsearch index with mapping
es.indices.create(index=elasticsearch_index, body=index_mapping, ignore=400)  # Ignore 400 status if the index
# already exists

# Read CSV into a Pandas DataFrame
df = pd.read_csv(csv_file_path)

# Convert DataFrame rows to JSON objects
data = df.to_dict(orient='records')

for doc in data:
    for key, value in doc.items():
        if pd.isna(value):  # Check for 'NaN' values
            doc[key] = None


def safe_int(value):
    try:
        return int(value)
    except (ValueError, TypeError):
        return


# manually converting to Numeric data
for doc in data:
    doc['AnnualSalary'] = safe_int(doc['AnnualSalary'])


# Define a generator function to prepare data for bulk indexing
def actions():
    for doc in data:
        yield {
            "_index": elasticsearch_index,
            "_source": doc
        }


# Bulk index data into Elasticsearch
success, failed = helpers.bulk(es, actions(), chunk_size=1000, index=elasticsearch_index, raise_on_error=True)

print(f"Successfully indexed {success} documents. Failed to index {failed} documents.")
