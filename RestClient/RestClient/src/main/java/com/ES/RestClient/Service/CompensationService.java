package com.ES.RestClient.Service;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.JsonData;
import com.ES.RestClient.Exception.ServiceException;
import com.ES.RestClient.Model.CompData;
import com.ES.RestClient.Model.CompDataDto;
import com.ES.RestClient.utils.CompDataUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CompensationService {

    private final Logger logger = Logger.getLogger(String.valueOf(CompensationService.class));
    private final ElasticsearchClient esClient;

    public CompensationService(ElasticsearchClient esClient) {
        this.esClient = esClient;
    }

    public CompDataDto getCompDataById(String id) {
        try {
            GetResponse<CompData> response = esClient.get(g -> g
                    .index("compensation_data111")
                    .id(id), CompData.class);

            if (response.found()) {
                CompData compData = response.source();
                return CompDataUtil.mapToCompDataDTO(compData);
            } else {
                logger.warning("Document with ID " + id + " not found.");
                return null;
            }
        } catch (Exception e) {
            logger.warning("Error while fetching data by ID: " + e.getMessage());
            throw new ServiceException("Error while fetching data by ID", e);
        }
    }

    public List<CompDataDto> searchCompData(String field, String searchText) {
        try {
            SearchResponse<CompData> response = esClient.search(s -> s
                            .index("compensation_data111")
                            .query(q -> q
                                    .match(t -> t
                                            .field(field)
                                            .query(searchText)
                                    )
                            ),
                    CompData.class
            );

            return response.hits().hits().stream()
                    .map(hit -> CompDataUtil.mapToCompDataDTO(hit.source()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.warning("Error while searching data: " + e.getMessage());
            throw new ServiceException("Error while searching data", e);
        }
    }

    public List<CompDataDto> getCompDataBySalary(String fieldName, Double minSalary) {
        try {
            SearchResponse<CompData> response = esClient.search(s -> s
                            .index("compensation_data111")
                            .query(q -> q
                                    .range(r -> r
                                            .field(fieldName)
                                            .gt(JsonData.of(minSalary))
                                    )
                            ),
                    CompData.class
            );

            return response.hits().hits().stream()
                    .map(hit -> CompDataUtil.mapToCompDataDTO(hit.source()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.warning("Error while fetching data by salary: " + e.getMessage());
            throw new ServiceException("Error while fetching data by salary", e);
        }
    }

    public List<CompDataDto> getCompData(String sortField, String sortOrder) {
        try {
            SearchResponse<CompData> response = esClient.search(s -> s
                            .index("compensation_data111")
                            .sort(sort -> {
                                if ("desc".equalsIgnoreCase(sortOrder)) {
                                    return sort.field(field -> field.field(sortField).order(SortOrder.Desc));
                                } else {
                                    return sort.field(field -> field.field(sortField));
                                }
                            })
                            .size(10000),
                    CompData.class
            );

            return response.hits().hits().stream()
                    .map(hit -> CompDataUtil.mapToCompDataDTO(hit.source()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.warning("Error while fetching sorted data: " + e.getMessage());
            throw new ServiceException("Error while fetching sorted data", e);
        }
    }
}
