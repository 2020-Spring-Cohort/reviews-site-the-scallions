package org.wecancodeit.reviews.Models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.ReviewStorage;

import java.util.HashMap;

@Controller
public class CategoryController {
    private HashMap<Long, Category> categories;
    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;


    public CategoryController(CategoryStorage categoryStorage, ReviewStorage reviewStorage) {
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
        categories = new HashMap<>();
        Category redWine = new Category("Red Wine", "this is red wine");
        Category whiteWine = new Category("White Wine", "this is white wine");
        categories.put(redWine.getId(), redWine);
        categories.put(whiteWine.getId(), whiteWine);
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "HomePage";

    }

    @RequestMapping("/categories/{id}")
    public String displaySingleCategory(@PathVariable Long id, Model model) {
        Category retrieveCategory = categoryStorage.findCategoryById(id);
        model.addAttribute("category", retrieveCategory);
        return "CategoryTemplate";
    }

//    @RequestMapping("reviews/{id}")
//    public String displayReviews(@PathVariable Long id, Model model) {
//        Category retrieveCategory = categoryStorage.findCategoryById(id);
//        model.addAttribute("reviews",retrieveCategory.getReview());
//        return "CategoryTemplate";
//}
//    @GetMapping("/review/{id}")
//    public String displaySingleReview(@PathVariable Long id, Model model) {
//        Review retrievedReview = reviewStorage.findReviewById(id);
//        model.addAttribute("Review", retrievedReview);
//        return "CategoryTemplate";
//    }
    @PostMapping("/add-review")
    public String addReview(@RequestParam String wineName, @RequestParam String reviewText, @RequestParam Long categoryId) {
        Category category = categoryStorage.findCategoryById(categoryId);
        reviewStorage.store(new Review( category,wineName, reviewText));
        return"redirect:categories/"+ categoryId;
    }

}
