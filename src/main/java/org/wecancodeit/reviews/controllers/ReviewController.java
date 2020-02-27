package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.storage.repositories.CommentRepository;
import org.wecancodeit.reviews.Models.HashTag;
import org.wecancodeit.reviews.storage.repositories.HashTagRepository;
import org.wecancodeit.reviews.Models.Comment;
import org.wecancodeit.reviews.Models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;

import java.util.Optional;

@Controller
public class ReviewController {
    private final ReviewStorage reviewStorage;
    private HashTagRepository hashTagRepo;
    private CommentRepository commentRepo;

    public ReviewController(ReviewStorage reviewStorage, HashTagRepository hashTagRepo, CommentRepository commentRepo) {

        this.reviewStorage = reviewStorage;
        this.hashTagRepo = hashTagRepo;
        this.commentRepo = commentRepo;
    }
    @RequestMapping("/review/{id}")
    public String displayReview(@PathVariable Long id, Model model) {
        Review retrievedReview = reviewStorage.findReviewById(id);
        model.addAttribute("Review", retrievedReview);
        return "ReviewTemplate";
    }
    @PostMapping("/review/{id}/add-hashtag")
    public String addHashTagToReview(@RequestParam String hashTagName, @PathVariable Long id) {
        HashTag hashTagToAddToReview;
        Optional<HashTag> hashTagToAddOpt = hashTagRepo.findByName(hashTagName);
        if (hashTagToAddOpt.isEmpty()) {
            hashTagToAddToReview = new HashTag(hashTagName);
            hashTagRepo.save(hashTagToAddToReview);
        } else {
            hashTagToAddToReview = hashTagToAddOpt.get();
        }
        Review reviewToAddHashTagTo = reviewStorage.findReviewById(id);
        reviewToAddHashTagTo.addHashTag(hashTagToAddToReview);
        reviewStorage.store(reviewToAddHashTagTo);
        return "redirect:/review/" + id;
    }
    @PostMapping("/review/{id}/add-comment")
    public String addCommentToReview(@RequestParam String comment, @PathVariable Long id) {
        Comment commentToAddToReview;
            commentToAddToReview = new Comment(comment,reviewStorage.findReviewById(id) );
            commentRepo.save(commentToAddToReview);
        Review reviewToAddCommentTo = reviewStorage.findReviewById(id);
        reviewToAddCommentTo.addComment(commentToAddToReview);
        reviewStorage.store(reviewToAddCommentTo);
        return "redirect:/review/" + id;
    }



}
