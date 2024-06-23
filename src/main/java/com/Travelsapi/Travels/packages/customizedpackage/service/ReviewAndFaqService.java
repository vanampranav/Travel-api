package com.Travelsapi.Travels.packages.customizedpackage.service;


import com.Travelsapi.Travels.packages.customizedpackage.models.ReviewAndFaq;
import com.Travelsapi.Travels.packages.customizedpackage.repository.ReviewAndFaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewAndFaqService {

    @Autowired
    private ReviewAndFaqRepository reviewAndFaqRepository;
    public List<ReviewAndFaq> getAllReviewsAndFaqs() {

        return reviewAndFaqRepository.findAll();
    }
    public ReviewAndFaq getReviewAndFaqById(int id) {

        return reviewAndFaqRepository.findById(id).orElse(null);
    }
    public ReviewAndFaq saveReviewAndFaq(ReviewAndFaq reviewAndFaq) {
        return reviewAndFaqRepository.save(reviewAndFaq);
    }
    public void deleteReviewAndFaq(int id) {

        reviewAndFaqRepository.deleteById(id);
    }
}
