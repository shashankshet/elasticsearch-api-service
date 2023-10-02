package com.ES.RestClient.Controller;


import com.ES.RestClient.Model.CompDataDto;
import com.ES.RestClient.Service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/compensation")
public class CompensationController {

    @Autowired
    private final CompensationService compensationService;

    public CompensationController(CompensationService compensationService) {
        this.compensationService = compensationService;
    }

    @GetMapping("/getCompDataById/{id}")
    public ResponseEntity<Object> getCompDataById(@PathVariable String id) throws IOException {
        CompDataDto responseDTO = compensationService.getCompDataById(id);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            String errorMessage = "Document with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/searchCompData")
    public ResponseEntity<Object> searchCompData(
            @RequestParam String field,
            @RequestParam String searchText) throws IOException {
        List<CompDataDto> searchResults = compensationService.searchCompData(field, searchText);
        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/getCompDataBySalary")
    public ResponseEntity<Object> getCompDataBySalary(
            @RequestParam(name = "fieldName") String fieldName,
            @RequestParam(name = "minSalary") Double minSalary) throws IOException {
        List<CompDataDto> matchingData = compensationService.getCompDataBySalary(fieldName, minSalary);
        if (matchingData.isEmpty()) {
            String errorMessage = "No records found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        return ResponseEntity.ok(matchingData);
    }

    @GetMapping("/getCompData")
    public ResponseEntity<Object> getCompData(
            @RequestParam(name = "sortField", required = false) String sortField,
            @RequestParam(name = "sortOrder", required = false, defaultValue = "asc") String sortOrder) throws IOException {
        List<CompDataDto> matchingData = compensationService.getCompData(sortField, sortOrder);
        if (matchingData.isEmpty()) {
            String errorMessage = "No records found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        return ResponseEntity.ok(matchingData);
    }
}