package com.ES.RestClient.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompData {

    @JsonProperty("Timestamp")
    private String Timestamp;
    @JsonProperty("Age")
    private String Age;
    @JsonProperty("Industry")
    private String Industry;
    @JsonProperty("JobTitle")
    private String JobTitle;
    @JsonProperty("AnnualSalary")
    private double AnnualSalary;
    @JsonProperty("Currency")
    private String Currency;
    @JsonProperty("Location")
    private String Location;
    @JsonProperty("WorkExperience")
    private String WorkExperience;
    @JsonProperty("AdditionalContext")
    private String AdditionalContext;
    @JsonProperty("OtherCurrency")
    private String OtherCurrency;


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



    @Override
    public String toString() {
        return "CompData{" +
                ", Timestamp='" + Timestamp + '\'' +
                ", Age='" + Age + '\'' +
                ", Industry='" + Industry + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", AnnualSalary=" + AnnualSalary +
                ", Currency='" + Currency + '\'' +
                ", Location='" + Location + '\'' +
                ", WorkExperience='" + WorkExperience + '\'' +
                ", AdditionalContext='" + AdditionalContext + '\'' +
                ", OtherCurrency='" + OtherCurrency + '\'' +
                '}';
    }

}
