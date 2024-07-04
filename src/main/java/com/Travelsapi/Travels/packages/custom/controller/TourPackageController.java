package com.Travelsapi.Travels.packages.custom.controller;

import com.Travelsapi.Travels.packages.custom.models.TourPackage;
import com.Travelsapi.Travels.packages.custom.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/tourPackages")
@RestController
public class TourPackageController {

    @Autowired
    private TourPackageService tourPackageService;

    @GetMapping
    public List<TourPackage> getAllTourPackages() {
        return tourPackageService.getAllTourPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourPackage> getTourPackageById(@PathVariable int id) {

        TourPackage tourPackage = tourPackageService.getTourPackageById(id);
        if (tourPackage != null) {
            return ResponseEntity.ok(tourPackage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TourPackage createTourPackage(@RequestBody TourPackage tourPackage) {
        return tourPackageService.saveTourPackage(tourPackage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTourPackage(@PathVariable int id) {
        tourPackageService.deleteTourPackage(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourPackage> updateTourPackage
            (@PathVariable int id, @RequestBody TourPackage tourPackageDetails) {
        TourPackage tourPackage = tourPackageService.getTourPackageById(id);
        if (tourPackage != null) {
            tourPackage.setPackage_name(tourPackageDetails.getPackage_name());
            tourPackage.setDescription(tourPackageDetails.getDescription());
            tourPackage.setPrice(tourPackageDetails.getPrice());
            tourPackage.setAvailability(tourPackageDetails.getAvailability());
            tourPackage.setTotal_price(tourPackageDetails.getTotal_price());
            tourPackage.setStatus(tourPackageDetails.getStatus());
            tourPackage.setInclusion(tourPackageDetails.getInclusion());
            tourPackage.setExclusion(tourPackageDetails.getExclusion());
            final TourPackage updatedTourPackage = tourPackageService.saveTourPackage(tourPackage);
            return ResponseEntity.ok(updatedTourPackage);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/inclusion")
    public ResponseEntity<TourPackage> updateInclusion
            (@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            TourPackage tourPackage = tourPackageService.updateInclusion(id, file.getBytes());
            if (tourPackage != null) {
                return ResponseEntity.ok(tourPackage);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/{id}/exclusion")
    public ResponseEntity<TourPackage> updateExclusion
            (@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            TourPackage tourPackage = tourPackageService.updateExclusion(id, file.getBytes());
            if (tourPackage != null) {
                return ResponseEntity.ok(tourPackage);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }



}
