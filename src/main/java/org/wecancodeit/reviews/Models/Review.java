package org.wecancodeit.reviews.Models;

public class Review {
    private Category category;
    private String name;
    private String text; //text of the review
    private long id;


    public Review(Category category, String name, String text, long reviewId) {
        this.category = category;
        this.name = name;
        this.text = text;
        this.id = reviewId;

    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }


    public long getid() {
        return id;
    }
}
