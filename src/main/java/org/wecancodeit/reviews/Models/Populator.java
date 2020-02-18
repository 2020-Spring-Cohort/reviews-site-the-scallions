package org.wecancodeit.reviews.Models;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    CategoryStorage categoryStorage;

    public Populator(CategoryStorage categoryStorage){this.categoryStorage = categoryStorage; }

    @Override
    public void run(String... args) throws Exception{
        categoryStorage.store(new Category("Red",1,"This revolting merlot is full-bodied and dry, with hints of dragon blood and unicorn flesh and a sweet finish of nitrogen salts and vaporous aluminum chloride."));
        categoryStorage.store(new Category("Red",2,"This cannibal chianti graces the palate with the taste of fava beans and liver."));
        categoryStorage.store(new Category("Red",3,"This rich cabsav is noted for its floral nose and ability to confer immortality on the one who drinks it."));
        categoryStorage.store(new Category("Red",4,"This premium Shiraz is manufactured in Narnia, with a strong flavor of freshly-cut grass and just a hint of manticore teeth on the finish."));
        categoryStorage.store(new Category("White",5,"This shimmering chardonnay has a long history of use in the eldritch rituals of Yog-Sothoth"));
        categoryStorage.store(new Category("White",6,"This riesling was fermented from the finest of Sicilian grapes mixed with Satan's tears."));
        categoryStorage.store(new Category("White",7,"This Shire moscato is treaded out by fair Hobbit-maidens after the passing of the elves"));
        categoryStorage.store(new Category("White",8,"This pinot grigio is well-known for its fruity aroma and its property of giving the drinker temporary telepathy."));
    }
}
