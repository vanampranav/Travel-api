package com.Travelsapi.Travels.packages.custom.models;


import com.Travelsapi.Travels.locations.destinations.models.Destination;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity
@Table(name = "tour_package_destination")
public class PackageDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinTable(name = "package_id")
    private TourPackage tourPackage;

    @ManyToOne
    @JoinTable(name = "destination_id")
    private Destination destination;

    private int no_of_nights;
}
