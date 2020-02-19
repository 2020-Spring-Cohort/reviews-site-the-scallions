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
        Category testCategory = new Category("Red","Merlot");
        when(mockStorage.findCategoryById(34L)).thenReturn(testCategory);
        underTest.displaySingleCategory(34L, mockModel);
        verify(mockStorage).findCategoryById(34L);
        verify(mockModel).addAttribute("category", testCategory);
    }
    @Test
    public void shouldReturnViewNamedCategoryViewWhenDisplaySingleCategoryIsCalled(){
        String viewName = underTest.displaySingleCategory((long) 34, mockModel);
        assertThat(viewName).isEqualTo("CategoryTemplate");
    }
//    @Test
//    public void shouldGoToIndividualEndPoint() throws Exception {
//        Category testCategory = new Category("Red",34L,"Flannigan");
//        when(mockStorage.findCategoryById(34L)).thenReturn(testCategory);
//        mockMvc.perform(get("/categories/34"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("CategoryTemplate"))
//                .andExpect(model().attribute("category", testCategory));
//    }

    @Test
    public void categoryControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category("Red","Flannigan");
        Category whiteWine = new Category("White Wine",  "this is white wine");
        List<Category> categoryCollection = Collections.singletonList(testCategory);
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("HomePage"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoryCollection));
    }
}