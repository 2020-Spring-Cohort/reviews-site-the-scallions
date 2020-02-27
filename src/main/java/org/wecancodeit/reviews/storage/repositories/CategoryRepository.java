package org.wecancodeit.reviews.storage.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Category;

import java.util.Collection;
import java.util.Optional;


    public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findCategoryById(Long id);

    Collection<Category> findAll();
}
