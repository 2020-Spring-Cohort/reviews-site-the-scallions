package org.wecancodeit.reviews.Models;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    @ManyToOne
    private Review review;

    public Comment() {}
    public Comment(String comment, Review review) {
        this.comment = comment;
        this.review = review;
    }
    public String getComment() {
        return comment;
    }

    public Long getId() {
        return id;
    }

    public Review getReview() {
        return review;
    }
}

