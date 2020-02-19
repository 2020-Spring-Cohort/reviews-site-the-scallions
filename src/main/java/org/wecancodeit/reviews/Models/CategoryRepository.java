package org.wecancodeit.reviews.Models;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


    public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findCategoryById(Long id);

    Collection<Category> findAll();
}
