package org.wecancodeit.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    public HashTag(String name) {
        this.name = name;
    }

    public HashTag() {
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
        return id.equals(hashTag.id) &&
                name.equals(hashTag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
