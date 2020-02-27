package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.wecancodeit.reviews.Models.*;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;
import org.wecancodeit.reviews.storage.repositories.CommentRepository;
import org.wecancodeit.reviews.storage.repositories.HashTagRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HashTagRepository hashTagRepo;
    @Autowired
    private CommentRepository commentRepo;

    @Test

    public void categoryShouldHaveAListOfReviews() {
        Category testCategory = new Category("Red Wine", "Flannigan");
        Review testReview = new Review(testCategory, "Red", "review text");
        categoryRepo.save(testCategory);
        reviewRepo.save(testReview);
        entityManager.flush();
        entityManager.clear();
        Optional<Category> retrievedCategoryOptional = categoryRepo.findCategoryById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOptional.get();
        Review retrievedReview = reviewRepo.findById(testReview.getId()).get();
        assertThat(retrievedCategory.getReview()).contains(testReview);
    }

    @Test
    public void reviewsShouldBeAbleToHaveMultipleHashtags() {
        HashTag hashTag1 = new HashTag("sweet");
        HashTag hashTag2 = new HashTag("dry");
        Category testCategory = new Category("Red", "Jammy");
        Review testReview1 = new Review(testCategory, "White", "reviewText",  hashTag1, hashTag2);
        Review testReview2 = new Review(testCategory, "Red", "reviewText",  hashTag1, hashTag2);
        Review testReview3 = new Review(testCategory, "White", "reviewText", hashTag1, hashTag2);
        hashTagRepo.save(hashTag1);
        hashTagRepo.save(hashTag2);
        categoryRepo.save(testCategory);
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        reviewRepo.save(testReview3);
        entityManager.flush();
        entityManager.clear();
        Review retrievedReview = reviewRepo.findById(testReview1.getId()).get();
        HashTag retrievedHashTag1 = hashTagRepo.findById(hashTag1.findByID()).get();
        HashTag retrievedHashTag2 = hashTagRepo.findById(hashTag2.findByID()).get();
        assertThat(retrievedReview.getHashtags()).contains(hashTag1, hashTag2);
        assertThat(retrievedHashTag1.getReviews()).contains(testReview1, testReview3);
        assertThat(retrievedHashTag2.getReviews()).contains(testReview1, testReview2);
    }
    @Test
    public void reviewsShouldBeAbleToHaveMultipleComments() {
        Category testCategory = new Category("Red", "Jammy");
        Review testReview1 = new Review(testCategory, "red", "reviewText");
        Comment comment1 = new Comment("nice", testReview1);
        Comment comment2 = new Comment("nasty", testReview1);
        commentRepo.save(comment1);
        commentRepo.save(comment2);
        categoryRepo.save(testCategory);
        reviewRepo.save(testReview1);
        entityManager.flush();
        entityManager.clear();
        Review retrievedReview = reviewRepo.findById(testReview1.getId()).get();
        Comment retrievedComment1 = commentRepo.findById(comment1.getId()).get();
        Comment retrievedComment2 = commentRepo.findById(comment1.getId()).get();
        assertThat(retrievedComment1.getReview().equals(testReview1));
        assertThat(retrievedComment2.getReview().equals(testReview1));
    }
}
