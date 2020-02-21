package org.wecancodeit.reviews.Models;

import org.wecancodeit.reviews.HashTag;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Category category;
    private String name;
    private String text; //text of the review
   @ManyToMany
   private Collection<HashTag> hashtags;




    public Review(Category category, String name, String text, HashTag... hashTags) {
        this.category = category;
        this.name = name;
        this.text = text;
        this.hashtags = Arrays.asList(hashTags);


    }
    public Review(){}

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }


    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return id.equals(review.id) &&
                Objects.equals(category, review.category) &&
                Objects.equals(name, review.name) &&
                Objects.equals(text, review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, text);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public Collection<HashTag> getHashTag() {
        return hashtags;
    }
}
