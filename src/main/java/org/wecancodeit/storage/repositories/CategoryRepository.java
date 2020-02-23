package org.wecancodeit.storage.repositories;
import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.Category;

import java.util.Collection;
import java.util.Optional;


    public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findCategoryById(Long id);

    Collection<Category> findAll();
}
