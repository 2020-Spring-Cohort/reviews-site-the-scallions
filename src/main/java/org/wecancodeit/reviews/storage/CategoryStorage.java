package org.wecancodeit.reviews.storage;



import org.wecancodeit.reviews.Models.Category;

import java.util.Collection;

public interface CategoryStorage  {
    Collection<Category> findAllCategories();
    void store(Category category);
    Category findCategoryById(Long id);
}
