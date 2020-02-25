package org.wecancodeit.reviews.Models;

import org.wecancodeit.reviews.HashTag;

import javax.persistence.*;
import java.util.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Category category;
    private String wineName;
    private String text; //text of the review
   @ManyToMany
   private Set<HashTag> hashtags;




    public Review(Category category, String wineName, String text, HashTag... hashTags) {
        this.category = category;
        this.wineName = wineName;
        this.text = text;
//        this.hashtags = Arrays.asList(hashTags);
        this.hashtags = new HashSet<>();



    }
    public Review(){}
    public Collection<HashTag> getHashtags() {
        return hashtags;
    }

    public Category getCategory() {
        return category;
    }

    public String getWineName() {
        return wineName;
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
                Objects.equals(wineName, review.wineName) &&
                Objects.equals(text, review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, wineName, text);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + wineName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public Collection<HashTag> getHashTag() {
        return hashtags;
    }

    public void addHashTag(HashTag hashTagToAddToReview) {
        hashtags.add(hashTagToAddToReview);
    }
}
