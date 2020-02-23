package org.wecancodeit.reviews.Models;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.ReviewStorage;

import java.util.Collection;

@Service
public class ReviewStorageJpaImpl implements ReviewStorage {
    private final ReviewRepository reviewRepository;

    public ReviewStorageJpaImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review findReviewById(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public void store(Review reviewToStore) {
         reviewRepository.save(reviewToStore);

    }
}
