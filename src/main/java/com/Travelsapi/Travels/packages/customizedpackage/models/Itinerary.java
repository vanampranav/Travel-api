package com.Travelsapi.Travels.packages.customizedpackage.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itinerary_id;

    private int no_of_days;

    @Column(columnDefinition = "TEXT")
    private String description ;


    @ManyToOne
    @JoinColumn(name = "tour_package_id")
    private TourPackage tourPackage;

}
