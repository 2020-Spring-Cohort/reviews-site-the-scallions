package org.wecancodeit.reviews.Models;

import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {


    Optional<Review> findById(Long id);
}
