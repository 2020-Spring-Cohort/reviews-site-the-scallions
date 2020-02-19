package org.wecancodeit.reviews.Models;



import java.util.Collection;


public interface CategoryStorage  {
    Collection<Category> findAllCategories();
    void store(Category category);
    Category findCategoryById(Long id);
}
