package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.HashTag;
import org.wecancodeit.reviews.Models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;
import org.wecancodeit.reviews.storage.ReviewStorageJpaImpl;
import org.wecancodeit.reviews.storage.ReviewStorage;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReviewStorageJpaImplTest {
    private ReviewRepository ReviewRepo;
    private ReviewStorage underTest;
    private Review testReview;
    @BeforeEach
    void setUp() {
        ReviewRepo = mock(ReviewRepository.class);
        underTest = new ReviewStorageJpaImpl(ReviewRepo);
        Category testCategory = new Category("red","fantastic");
        HashTag testHashTag = new HashTag("#cool");
        testReview = new Review(testCategory, "red", "its awesome", testHashTag);
    }
    @Test
    public void shouldFindReviewById() {
        when(ReviewRepo.findById(1L)).thenReturn(Optional.of(testReview));
        Review retrievedReview = underTest.findReviewById(1L);
        assertThat(retrievedReview).isEqualTo(testReview);
    }
    @Test
    public void shouldStoreReview() {
        underTest.store(testReview);
        verify(ReviewRepo).save(testReview);
    }

    }
