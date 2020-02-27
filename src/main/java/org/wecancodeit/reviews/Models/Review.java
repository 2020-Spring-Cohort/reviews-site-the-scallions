package org.wecancodeit.reviews.Models;

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
   @ManyToMany()
   private Collection<HashTag> hashtags;
   @OneToMany()
    private Set<Comment> comments;


    public Review(Category category, String wineName, String text, HashTag... hashTags) {
        this.category = category;
        this.wineName = wineName;
        this.text = text;
        this.hashtags = new ArrayList<HashTag>(Arrays.asList(hashTags));
        this.comments = new HashSet<>();



    }
    public Review(){}

    public Collection<Comment> getComments() { return comments;}
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


    public Collection<Comment> getComment() {
        return comments;
    }

    public void addHashTag(HashTag hashTagToAddToReview) {
       if (!this.hashtags.contains(hashTagToAddToReview)) {
          hashtags.add(hashTagToAddToReview);
      }
    }
    public void addComment(Comment commentToAddToReview) {
        comments.add(commentToAddToReview);
    }
}
