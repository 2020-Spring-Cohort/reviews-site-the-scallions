package org.wecancodeit.reviews;

import org.wecancodeit.reviews.Models.Review;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
@Entity
public class HashTag {
    @Id
    @GeneratedValue
    private String name;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Review> taggedReviews;

    public HashTag(String name) {
        this.name = name;
    }
public HashTag(){}
    public String getName() {
        return name;
    }
}
