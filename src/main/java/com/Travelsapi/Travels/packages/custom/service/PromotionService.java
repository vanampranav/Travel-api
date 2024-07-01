package com.Travelsapi.Travels.packages.custom.service;


import com.Travelsapi.Travels.packages.custom.models.Promotion;
import com.Travelsapi.Travels.packages.custom.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();

    }
    public Promotion getPromotionById(int id) {

        return promotionRepository.findById(id).orElse(null);
    }
    public Promotion savePromotion(Promotion promotion) {

        return promotionRepository.save(promotion);
    }
    public void deletePromotion(int id) {

        promotionRepository.deleteById(id);
    }
}
