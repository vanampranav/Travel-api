package com.Travelsapi.Travels.locations.countries.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String iso3;

    private String phonecode;
    private String capital;
    private String currency;
    private String currencyName;
    private String currencySymbol;

    private Double latitude;
    private Double longitude;
    private String emoji;
    private String emojiU;
    private Date createdAt;
    private Date updatedAt;
    private Boolean service_accept;
}
