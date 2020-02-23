package org.wecancodeit.reviews.Models;

import org.wecancodeit.reviews.ReviewStorage;

import java.util.Collection;

public class ReviewStorageJpaImpl implements ReviewStorage {

    @Override
    public Collection<Review> getAll() {
        return (Collection<Review>) repository.findAll();
    }

    @Override
    public Review findReviewById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void store(Review reviewToStore) {
        return repository.save(newReview);

    }
}
