package org.wecancodeit.Models;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.storage.CategoryStorage;
import org.wecancodeit.storage.HashTagStorage;
import org.wecancodeit.storage.ReviewStorage;

@Component
public class Populator implements CommandLineRunner {

    private final CategoryStorage categoryStorage;
    private final ReviewStorage reviewStorage;
    private final HashTagStorage hashTagStorage;

    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage, HashTagStorage hashTagStorage){
        this.categoryStorage = categoryStorage;
        this.hashTagStorage = hashTagStorage;
        this.reviewStorage = reviewStorage;
    }

    @Override
    public void run(String... args) throws Exception{
        Category merlot = new Category("Red","This revolting merlot is full-bodied and dry, with hints of dragon blood and unicorn flesh and a sweet finish of nitrogen salts and vaporous aluminum chloride.");
        categoryStorage.store(merlot);
        Category chianti = new Category("Red","This cannibal chianti graces the palate with the taste of fava beans and liver.");
        categoryStorage.store(chianti);
        Category cabsav = new Category("Red","This rich cabsav is noted for its floral nose and ability to confer immortality on the one who drinks it.");
        categoryStorage.store(cabsav);
        Category shiraz = new Category("Red","This premium Shiraz is manufactured in Narnia, with a strong flavor of freshly-cut grass and just a hint of manticore teeth on the finish.");
        categoryStorage.store(shiraz);
        Category chardonnay = new Category("White","This shimmering chardonnay has a long history of use in the eldritch rituals of Yog-Sothoth");
        categoryStorage.store(chardonnay);
        Category riesling = new Category("White","This riesling was fermented from the finest of Sicilian grapes mixed with Satan's tears.");
        categoryStorage.store(riesling);
        Category moscato = new Category("White","This Shire moscato is treaded out by fair Hobbit-maidens after the passing of the elves");
        categoryStorage.store(moscato);
        Category pinotGrigio = new Category("White","This pinot grigio is well-known for its fruity aroma and its property of giving the drinker temporary telepathy.");
        categoryStorage.store(pinotGrigio);
        HashTag newTag = new HashTag("Gordy");

        Review newRev = new Review(riesling,"Bob","Also Bob",newTag);
        reviewStorage.store(newRev);

    }
}
