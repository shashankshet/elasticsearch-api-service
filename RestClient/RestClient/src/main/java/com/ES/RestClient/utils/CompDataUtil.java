package com.ES.RestClient.utils;

import com.ES.RestClient.Model.CompData;
import com.ES.RestClient.Model.CompDataDto;

public class CompDataUtil {
    public static CompDataDto mapToCompDataDTO(CompData compData) {
        CompDataDto dto = new CompDataDto();
        dto.setLocation(compData.getLocation());
        dto.setTimestamp(compData.getTimestamp());
        dto.setCurrency(compData.getCurrency());
        dto.setJobTitle(compData.getJobTitle());
        dto.setAnnualSalary(compData.getAnnualSalary());
        dto.setAdditionalContext(compData.getAdditionalContext());
        dto.setWorkExperience(compData.getWorkExperience());
        dto.setAge(compData.getAge());
        dto.setOtherCurrency(compData.getOtherCurrency());
        dto.setIndustry(compData.getIndustry());
        return dto;
    }
}
