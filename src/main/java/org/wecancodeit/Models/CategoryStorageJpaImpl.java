package org.wecancodeit.Models;

import org.springframework.stereotype.Service;
import org.wecancodeit.storage.CategoryStorage;
import org.wecancodeit.storage.repositories.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoryStorage {
    private CategoryRepository categoryRepository;
    private  Collection<Category> categories;


    public CategoryStorageJpaImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<Category> findAllCategories() {
        return (Collection<Category>)categoryRepository.findAll();

    }

    @Override
    public void store(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public Category findCategoryById(Long id) {

        return categoryRepository.findCategoryById(id).get();
    }
}
