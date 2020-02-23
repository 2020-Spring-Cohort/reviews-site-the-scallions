package org.wecancodeit.storage;

import org.springframework.stereotype.Component;
import org.wecancodeit.Models.Review;

import java.util.Collection;

@Component
public interface ReviewStorage {
    Collection<Review> findAllReviews();
    Review findReviewById(Long id);
    void store(Review reviewToStore);

}
