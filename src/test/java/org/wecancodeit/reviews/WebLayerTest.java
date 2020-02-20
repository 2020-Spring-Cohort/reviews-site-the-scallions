package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.CategoryStorage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {
    @MockBean
    CategoryStorage mockStorage;
    @MockBean
    ReviewStorage reviewStorage;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void categoriesShouldBeOKAndReturnTheCategoriesViewWithCategoriesModelAttribute() throws Exception {
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("HomePage"))
                .andExpect(model().attributeExists("categories"));
    }
    @Test
    public void shouldReceiveOKFromSingleCategoryEndpoint() throws Exception {
        Category testCategory = new Category("Red Wine", "good wine");
        when(mockStorage.findCategoryById(1L)).thenReturn(testCategory);
        mockMvc.perform(get("/categories/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("CategoryTemplate"))
                .andExpect(model().attributeExists("category"));
    }
}
