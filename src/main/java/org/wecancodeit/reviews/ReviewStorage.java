package org.wecancodeit.reviews;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Review;
@Repository
public interface ReviewStorage {
    Review findReviewById(Long id);

    void store(Review reviewToStore);
}
