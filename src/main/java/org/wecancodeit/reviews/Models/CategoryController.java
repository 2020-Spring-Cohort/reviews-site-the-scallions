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

    public CategoryController() {
        categories = new HashMap<>();
        Category redWine = new Category("Red Wine", 34, "this is Red Wine");
        Category whiteWine = new Category("White Wine", 35, "this is whitewine");
        categories.put(redWine.getId(), redWine);
        categories.put(whiteWine.getId(), whiteWine);
    }

    @RequestMapping("/")
    public String displayCategories(Model model) {
        model.addAttribute("categories", categories.values());
        return "HomePage";

    }
    @RequestMapping("/{id}")
    public String displaySingleCategory(@PathVariable Long id, Model model) {
        Category retrieveCategory = categories.get(id);
        model. addAttribute("1234",retrieveCategory);
        return "CategoryTemplate";



    }
}
