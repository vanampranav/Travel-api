package com.Travelsapi.Travels.packages.custom.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotion_id;
    private String promotion_code;
    private Date start_date;
    private Date end_date;
    private float decimal_percentage;
    private float minimum_purchase_amount;

    @ManyToOne
    @JoinColumn(name = "tour_package_id")
    private TourPackage tourPackage;
 }
