package com.Travelsapi.Travels.packages.custom.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttractionDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    // if necessary we can add type field
    /* @JsonProperty("type")
    private String type;*/

}
