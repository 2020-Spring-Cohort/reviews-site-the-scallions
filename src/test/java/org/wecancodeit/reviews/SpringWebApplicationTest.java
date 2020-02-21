package org.wecancodeit.reviews;

import org.springframework.test.annotation.DirtiesContext;


    import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;


import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.CategoryStorage;
import org.wecancodeit.reviews.Models.Review;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @DirtiesContext
    @SpringBootTest
    @AutoConfigureMockMvc
    public class SpringWebApplicationTest {
        @Autowired
        private MockMvc mockMvc;
        @MockBean
        private CategoryStorage categoryStorage;
        @MockBean
        ReviewStorage reviewStorage;
        @MockBean
        HashTagStorage hashTagStorage;
        @Test
        public void shouldReceiveOKFromCategoriesEndpoint() throws Exception {
            mockMvc.perform(get("/categories"))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
        @Test
        public void shouldReceiveOKFromSingleCategoryEndpoint() throws Exception {
            Category testCategory = new Category("Red","Good");
            when(categoryStorage.findCategoryById(1L)).thenReturn(testCategory);
            mockMvc.perform(get("/categories/1"))
                    .andExpect(status().isOk());
        }
    }







