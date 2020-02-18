package org.wecancodeit.reviews.Models;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CategoryStorage extends CrudRepository<Category, Long> {
    Collection<Category> findAllCategories();
    void store(Category category);



    Category findCategoryById(long id);
}
