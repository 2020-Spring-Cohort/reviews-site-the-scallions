package org.wecancodeit.reviews.Models;

import java.util.Set;

public class Category {
    private String type; //red or white
    private long id; //specific name
    private String description; //manufacturer's description
    private Set tags; //using sets for ease of checking using .contains(object) method

    public Category(String type, long id, String description) {
        this.type = type;
        this.id = id;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Set getTags() {
        return tags;
    }

    public boolean hasTag(String tag){
        return this.tags.contains(tag.toUpperCase());
    }
}
