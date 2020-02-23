package org.wecancodeit.storage;

import org.wecancodeit.Models.Category;

import java.util.Collection;


public interface CategoryStorage  {
    Collection<Category> findAllCategories();
    void store(Category category);
    Category findCategoryById(Long id);
}
