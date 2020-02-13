package org.wecancodeit.reviews.Models;

public class Review {
    private Category category;
    private String name;
    private String text; //text of the review


    public Review(Category category, String name, String text) {
        this.category = category;
        this.name = name;
        this.text = text;
    }
}
