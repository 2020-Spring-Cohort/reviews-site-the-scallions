package org.wecancodeit.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id; //specific name

    private String type; //red or white
    private String description; //manufacturer's description



    @OneToMany(mappedBy = "category")
    private Collection <Review> reviews;

    public Category(String type, String description) {
        this.type = type;
        this.description = description;
    }
    public Category(){}

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {

        return description;
    }

    public Collection<Review> getReview() {
        return reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                Objects.equals(type, category.type) &&
                Objects.equals(description, category.description);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, description);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
