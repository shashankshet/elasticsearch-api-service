package com.ES.RestClient.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompDataDto {
    private String Timestamp;
    private String Age;
    private String Industry;
    private String JobTitle;
    private double AnnualSalary;
    private String Currency;
    private String Location;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public double getAnnualSalary() {
        return AnnualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        AnnualSalary = annualSalary;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getWorkExperience() {
        return WorkExperience;
    }

    public void setWorkExperience(String workExperience) {
        WorkExperience = workExperience;
    }

    public String getAdditionalContext() {
        return AdditionalContext;
    }

    public void setAdditionalContext(String additionalContext) {
        AdditionalContext = additionalContext;
    }

    public String getOtherCurrency() {
        return OtherCurrency;
    }

    public void setOtherCurrency(String otherCurrency) {
        OtherCurrency = otherCurrency;
    }

    private String WorkExperience;
    private String AdditionalContext;
    private String OtherCurrency;

}
