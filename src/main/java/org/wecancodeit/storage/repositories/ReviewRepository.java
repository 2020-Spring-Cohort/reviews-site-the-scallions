package org.wecancodeit.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.Review;


import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {


    Optional<Review> findById(Long id);
}
