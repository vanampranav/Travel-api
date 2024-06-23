package com.Travelsapi.Travels.packages.customizedpackage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TourPackage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String package_name;
    private String description;
    private Double price;
    private Boolean availability;
    private Double total_price;
    private String status;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String inclusion;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private  String exclusion;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Itinerary> itineraries;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReviewAndFaq> reviewsAndFaqs;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Promotion> promotions;


}
