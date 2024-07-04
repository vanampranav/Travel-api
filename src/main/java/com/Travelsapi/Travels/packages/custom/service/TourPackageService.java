package com.Travelsapi.Travels.packages.custom.service;

import com.Travelsapi.Travels.packages.custom.models.TourPackage;
import com.Travelsapi.Travels.packages.custom.repository.PackageRepository;
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

    public TourPackage updateInclusion(int id, byte[] inclusion) {
        TourPackage tourPackage = tourPackageRepository.findById(id).orElse(null);
        if (tourPackage != null) {
            tourPackage.setInclusion(inclusion);
            tourPackageRepository.save(tourPackage);
        }
        return tourPackage;
    }

    public TourPackage updateExclusion(int id, byte[] exclusion) {
        TourPackage tourPackage = tourPackageRepository.findById(id).orElse(null);
        if (tourPackage != null) {
            tourPackage.setExclusion(exclusion);
            tourPackageRepository.save(tourPackage);
        }
        return tourPackage;
    }
}
