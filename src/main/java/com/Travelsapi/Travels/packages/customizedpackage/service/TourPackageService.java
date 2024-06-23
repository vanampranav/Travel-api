package com.Travelsapi.Travels.packages.customizedpackage.service;

import com.Travelsapi.Travels.packages.customizedpackage.models.TourPackage;
import com.Travelsapi.Travels.packages.customizedpackage.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageService {

    @Autowired
    private PackageRepository tourPackageRepository;

    public List<TourPackage> getAllTourPackages() {

        return tourPackageRepository.findAll();
    }

    public TourPackage getTourPackageById(int id) {

        return tourPackageRepository.findById(id).orElse(null);
    }
    public TourPackage saveTourPackage(TourPackage tourPackage) {

        return tourPackageRepository.save(tourPackage);
    }
    public void deleteTourPackage(int id) {

        tourPackageRepository.deleteById(id);
    }
}
