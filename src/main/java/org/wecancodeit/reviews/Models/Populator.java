package org.wecancodeit.reviews.Models;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.ReviewStorage;

@Component
public class Populator implements CommandLineRunner {
    CategoryStorage categoryStorage;
    ReviewStorage reviewStorage;

    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage){
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
    }

    @Override
    public void run(String... args) throws Exception{
        Category redCat = new Category("Red","Red wine is wine that is red.");
        categoryStorage.store(redCat);
        Review redReview = new Review(redCat,"Chianti","This cannibal chianti graces the palate with the taste of fava beans and liver.");
        Review redReviewTwo = new Review(redCat,"Cabernet Sauvignon","This revolting merlot is full-bodied and dry, with hints of dragon blood and unicorn flesh and a sweet finish of nitrogen salts and vaporous aluminum chloride.");
        reviewStorage.store(redReview);
        reviewStorage.store(redReviewTwo);
//        categoryStorage.store(new Category("Red","This rich cabsav is noted for its floral nose and ability to confer immortality on the one who drinks it."));
//        categoryStorage.store(new Category("Red","This premium Shiraz is manufactured in Narnia, with a strong flavor of freshly-cut grass and just a hint of manticore teeth on the finish."));
        Category whiteCat = new Category("White","White wine is wine that is white. Tautologies are tautologies.");
        categoryStorage.store(whiteCat);
        Review whiteReview = new Review(whiteCat,"Riesling","This riesling was fermented from the finest of Sicilian grapes mixed with Satan's tears.");
        Review whiteReviewTwo = new Review(whiteCat,"Moscato","This Shire moscato is treaded out by fair Hobbit-maidens after the passing of the elves");
        reviewStorage.store(whiteReview);
        reviewStorage.store(whiteReviewTwo);
//        categoryStorage.store(new Category("White","This Shire moscato is treaded out by fair Hobbit-maidens after the passing of the elves"));
//        categoryStorage.store(new Category("White","This pinot grigio is well-known for its fruity aroma and its property of giving the drinker temporary telepathy."));

    }
}
