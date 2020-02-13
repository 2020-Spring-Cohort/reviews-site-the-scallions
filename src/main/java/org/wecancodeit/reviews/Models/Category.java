package org.wecancodeit.reviews.Models;

import java.util.Set;

public class Category {
    private String type; //red or white
    private String name; //specific name
    private String blurb; //manufacturer's description
    private Set tags; //using sets for ease of checking using .contains(object) method

    public Category(String type, String name, String blurb) {
        this.type = type;
        this.name = name;
        this.blurb = blurb;
    }

    public boolean hasTag(String tag){
        return this.tags.contains(tag.toUpperCase());
    }
}
