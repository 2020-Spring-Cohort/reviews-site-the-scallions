package org.wecancodeit.reviews;

import com.sun.xml.bind.v2.model.core.ID;
import org.wecancodeit.reviews.Models.Review;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class HashTag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Review> reviews;


    protected HashTag() {}
    public HashTag(String name) {
        reviews = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long findByID() {
        return id;
    }

    public Collection<Review> getReviews() {
     return reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashTag)) return false;
        HashTag hashTag = (HashTag) o;

        if (id != null ? !id.equals(hashTag.id) : hashTag.id != null) return false;
        return name != null ? name.equals(hashTag.name) : hashTag.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
