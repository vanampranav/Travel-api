package com.Travelsapi.Travels.packages.customizedpackage.controller;

import com.Travelsapi.Travels.packages.customizedpackage.models.TourPackage;
import com.Travelsapi.Travels.packages.customizedpackage.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
