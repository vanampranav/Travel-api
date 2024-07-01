package com.Travelsapi.Travels.locations.destinations.models;


import com.Travelsapi.Travels.locations.countries.models.Country;
import com.Travelsapi.Travels.packages.custom.models.TourPackage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Destinations")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String destinationType;
    //private String country;
    //private String country_id;
    //private String parentDestinationName;
    //private String parentDestinationId;
    private Double latitude;
    private Double longitude;
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @ManyToMany(mappedBy = "destinations")
    private List<TourPackage> tourPackages;
}
