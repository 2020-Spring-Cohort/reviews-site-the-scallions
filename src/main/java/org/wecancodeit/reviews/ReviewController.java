package org.wecancodeit.reviews;

import javafx.scene.text.FontPosture;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.Review;

import java.util.Optional;

@Controller
public class ReviewController {
    private final ReviewStorage reviewStorage;
    private HashTagRepository hashTagRepo;

    public ReviewController(ReviewStorage reviewStorage, HashTagRepository hashTagRepo) {

        this.reviewStorage = reviewStorage;
        this.hashTagRepo = hashTagRepo;
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



}
