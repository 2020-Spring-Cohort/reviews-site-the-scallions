package org.wecancodeit.reviews;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Review;

import java.util.Collection;


public interface ReviewStorage {


    Review findReviewById(Long id);

    void store(Review reviewToStore);

}
