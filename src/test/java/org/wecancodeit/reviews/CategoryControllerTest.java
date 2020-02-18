package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.CategoryController;
import org.wecancodeit.reviews.Models.CategoryStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {
    private MockMvc mockMvc;
    private CategoryController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoryController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }
    @Test
    public void shouldReturnViewWithOneCategory(){
        Category testCategory = new Category("Red",34,"Merlot");
        when(mockStorage.findCategoryById(34)).thenReturn(testCategory);
        underTest.displaySingleCategory(34L, mockModel);
        verify(mockStorage).findCategoryById(34);
        verify(mockModel).addAttribute("category", testCategory);
    }
    @Test
    public void shouldReturnViewNamedCategoryViewWhenDisplaySingleCategoryIsCalled(){
        String viewName = underTest.displaySingleCategory((long) 34, mockModel);
        assertThat(viewName).isEqualTo("CategoryTemplate");
    }
    @Test
    public void shouldGoToIndivudualEndPoint() throws Exception {
        Category testCategory = new Category("Red",34,"Flannigan");
        when(mockStorage.findCategoryById((long) 34)).thenReturn(testCategory);
        mockMvc.perform(get("/categories/34"))
                .andExpect(status().isOk())
                .andExpect(view().name("CategoryTemplate"))
                .andExpect(model().attributeExists("Category"))
                .andExpect(model().attribute("Category", testCategory));;
    }

    @Test
    public void categoryControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category("Red",(long)34,"Flannigan");
        List<Category> categoryCollection = Collections.singletonList(testCategory);
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("CategoriesTemplate"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoryCollection));
    }
}