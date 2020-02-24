package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.Models.Review;

@Controller
public class ReviewController {
    private final ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage) {

        this.reviewStorage = reviewStorage;
    }
    @RequestMapping("/review/{id}")
    public String displayReview(@PathVariable Long id, Model model) {
        Review retrievedReview = reviewStorage.findReviewById(id);
        model.addAttribute("Review", retrievedReview);
        return "ReviewTemplate";
    }

}
