package com.Travelsapi.Travels.packages.customizedpackage.controller;

import com.Travelsapi.Travels.packages.customizedpackage.models.ReviewAndFaq;
import com.Travelsapi.Travels.packages.customizedpackage.service.ReviewAndFaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviewsAndFaqs")
public class ReviewAndFaqController {
    @Autowired
    private ReviewAndFaqService reviewAndFaqService;

    @GetMapping
    public List<ReviewAndFaq> getAllReviewsAndFaqs() {
        return reviewAndFaqService.getAllReviewsAndFaqs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewAndFaq> getReviewAndFaqById(@PathVariable int id) {
        ReviewAndFaq reviewAndFaq = reviewAndFaqService.getReviewAndFaqById(id);
        if (reviewAndFaq != null) {
            return ResponseEntity.ok(reviewAndFaq);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ReviewAndFaq createReviewAndFaq(@RequestBody ReviewAndFaq reviewAndFaq) {
        return reviewAndFaqService.saveReviewAndFaq(reviewAndFaq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewAndFaq(@PathVariable int id) {
        reviewAndFaqService.deleteReviewAndFaq(id);
        return ResponseEntity.noContent().build();
    }
}
