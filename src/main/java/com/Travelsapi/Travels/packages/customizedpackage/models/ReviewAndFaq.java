package com.Travelsapi.Travels.packages.customizedpackage.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ReviewAndFaq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;

    private int  faq_id;
    private int rating;
    private String comment;
    private Date review_date;
    private String questions;

    @ManyToOne
    @JoinColumn(name = "tour_package_id")
    private TourPackage tourPackage;





}
