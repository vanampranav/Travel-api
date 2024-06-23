package com.Travelsapi.Travels.packages.customizedpackage.repository;

import com.Travelsapi.Travels.packages.customizedpackage.models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
}
