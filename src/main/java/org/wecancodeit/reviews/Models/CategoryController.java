package org.wecancodeit.reviews.Models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class CategoryController {
    private HashMap<Long, Category> categories;
    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
        categories = new HashMap<>();
        Category redWine = new Category("Red Wine", "this is red wine");
        Category whiteWine = new Category("White Wine",  "this is white wine");
        categories.put(redWine.getId(), redWine);
        categories.put(whiteWine.getId(), whiteWine);
    }

    @RequestMapping("/")
    public String displayCategories(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "HomePage";

    }
    @RequestMapping("/categories/{id}")
    public String displaySingleCategory(@PathVariable Long id, Model model) {
        Category retrieveCategory = categoryStorage.findCategoryById(id);
        model.addAttribute("category",retrieveCategory);
        return "CategoryTemplate";


    }
}
