package com.Travelsapi.Travels.packages.custom.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;


public class AttractionsDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    // if necessary we can add type field
    /* @JsonProperty("type")
    private String type;*/
}
