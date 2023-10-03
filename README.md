# elasticsearch-api-service

This project comprises two primary components:

- A Python administration script responsible for populating data into an Elasticsearch index.
- A Spring Boot application featuring exposed APIs designed to facilitate querying Elasticsearch based on user-provided request parameters.

### Initial Setup:
1. Run the python script (worker.py) which is used to load data into elastic search index.
2. Provide the follwong environment variables before running the python script.
   
  | ENVIRONMENT VARIABLE| VALUE            |
  | ------------------- | ---------------- |
  | ELASTICSEARCH_HOST  | `<HOST>`         |
  | ELASTICSEARCH_API_KEY | `<API_KEY>`     |
  | INDEX_NAME          | `<INDEX>`        |
  | CSV_FILE_PATH       | `<FILE_PATH>`    |

3. Execute the worker file.

---

### Running the Backend application
1. Open the project RestClient in the IDE of your choice.
2. Update the application.properties file with required values.
   
| ENVIRONMENT VARIABLE      | VALUE                         |
| ------------------------- | ----------------------------- |
| elasticsearch.serverUrl   | `<YOUR_ELASTICSEARCH_URL>`    |
| elasticsearch.apiKey      | `<YOUR_ELASTICSEARCH_API_KEY>` |

3. Run the main file of the SpringBoot Application. The Backend service will be up and running.
