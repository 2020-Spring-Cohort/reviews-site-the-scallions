package org.wecancodeit.reviews;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Review;

import java.util.Collection;

@Repository
public interface ReviewStorage {
    Collection<Review> getAll();

    Review findReviewById(Long id);

    void store(Review reviewToStore);

}
