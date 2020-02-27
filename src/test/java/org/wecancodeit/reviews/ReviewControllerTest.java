package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.Review;
import org.wecancodeit.reviews.controllers.ReviewController;
import org.wecancodeit.reviews.storage.repositories.CommentRepository;
import org.wecancodeit.reviews.storage.repositories.HashTagRepository;
import org.wecancodeit.reviews.storage.ReviewStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class ReviewControllerTest {


    private ReviewController underTest;
    private Model model;
    private ReviewStorage mockStorage;
    private Review testReview;
    private HashTagRepository hashTagRepo;
    private CommentRepository commentRepo;

@BeforeEach
    void setUp() {
        mockStorage = mock(ReviewStorage.class);
        hashTagRepo = mock(HashTagRepository.class);
        underTest = new ReviewController(mockStorage, hashTagRepo, commentRepo);
        model = mock(Model.class);
        Category testCategory = new Category("Red Wine", "fantastic");
        testReview = new Review( testCategory, "Test Description", "review text");
        when(mockStorage.findReviewById(1L)).thenReturn(testReview);
    }
    @Test
    public void displayReviewReturnsReviewTemplate() {
        String result = underTest.displayReview(1L, model);
        assertThat(result).isEqualTo("ReviewTemplate");
    }

    @Test
    public void displayReviewInteractsWithDependenciesCorrectly() {
    underTest.displayReview(1L, model);
    verify(mockStorage).findReviewById(1L);
    verify(model).addAttribute("Review",testReview);
    }
    @Test
    public void displayReviewMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/review/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("ReviewTemplate"))
                .andExpect(model().attributeExists("Review"))
                .andExpect(model().attribute("Review", testReview));
    }
}
