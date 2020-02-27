package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.Models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

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
    public void store(Review review) {
         reviewRepository.save(review);

    }
}
