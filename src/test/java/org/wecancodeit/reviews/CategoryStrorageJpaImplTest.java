package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.CategoryStorageJpaImpl;

import java.util.Collections;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStrorageJpaImplTest {


    @Test
    public void shouldFindAllCategoryes() {
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testCategory = new Category("red", "fantastic");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCategoryRepo);
        when(mockCategoryRepo.findAll()).thenReturn(Collections.singletonList(testCategory));
        underTest.store(testCategory);
        verify(mockCategoryRepo).save(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);
    }
    @Test
    public void shouldRetrieveSingleCategoryById() {
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testCategory1 = new Category("white", "awesome");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCategoryRepo);
        underTest.store(testCategory1);
        Optional<Category> testCategory1Optional = Optional.of(testCategory1);
        when(mockCategoryRepo.findById(1L)).thenReturn(testCategory1Optional);
        Category retrievedCategory1 = underTest.findCategoryById(1L);
        assertThat(retrievedCategory1).isEqualTo(testCategory1);
    }
}




