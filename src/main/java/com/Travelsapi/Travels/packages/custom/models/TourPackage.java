package com.Travelsapi.Travels.packages.custom.models;

import com.Travelsapi.Travels.locations.destinations.models.Destination;
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

    // Change variable names to plural wherever necessary
    @Lob
    @Column(columnDefinition = "BLOB")
    private Byte[] inclusion;

    @Lob
    @Column(columnDefinition = "BLOB")
    private  Byte[] exclusion;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Itinerary> itineraries;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReviewAndFaq> reviewsAndFaqs;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Promotion> promotions;

    @ManyToMany
    @JoinTable(
            name = "tour_package_destinations",
            joinColumns = @JoinColumn(name = "tour_package_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private List<Destination> destinations;
}
