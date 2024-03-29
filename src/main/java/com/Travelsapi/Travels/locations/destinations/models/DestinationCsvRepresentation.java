package com.Travelsapi.Travels.locations.destinations.models;


import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DestinationCsvRepresentation {

    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Destination_Type")
    private String destinationType;
    @CsvBindByName(column = "Country")
    private String country;
    @CsvBindByName(column = "Country_ID")
    private String country_id;
    @CsvBindByName(column = "Parent_Destination_Name")
    private String parentDestinationName;
    @CsvBindByName(column = "Parent_Destination_Id")
    private String parentDestinationId;
    @CsvBindByName(column = "Latitude")
    private Double latitude;
    @CsvBindByName(column = "Longitude")
    private Double longitude;
    @CsvBindByName(column = "Created_At")
    private Date createdAt;
    @CsvBindByName(column = "Updated_At")
    private Date updatedAt;

}
