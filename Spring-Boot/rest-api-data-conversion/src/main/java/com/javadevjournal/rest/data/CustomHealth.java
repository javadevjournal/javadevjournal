package com.javadevjournal.rest.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomHealth {

    private Map<String, Object> healthDetails;

    @JsonAnyGetter
    public Map<String, Object> getHealthDetails() {
        return this.healthDetails;
    }

    @JsonSetter
    public void setHealthDetails(Map<String, Object> healthDetails) {
        this.healthDetails = healthDetails;
    }


}
