package com.Travelsapi.Travels.Destination.models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Destinations")
@Builder
public class Destination {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
    private String destinationType;
    private String country;
    private String country_id;
    private String parentDestinationName;
    private String parentDestinationId;
    private Double latitude;
    private Double longitude;
    private Date createdAt;
    private Date updatedAt;
}
