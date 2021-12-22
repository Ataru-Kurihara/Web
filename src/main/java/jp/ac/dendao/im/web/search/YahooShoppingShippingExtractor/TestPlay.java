package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.IOException;

public class TestPlay {
    public static void main(String[] args) throws IOException {
        amazon a = new amazon();
        for(String s:a.getItemName()){
            System.out.println(s);

        }





        String[] category_e = {
                "todays-deals", "audible", "amazonfresh", "life", "amazon-device", "digital-text", "instant-video"
                , "alexa-skills", "digital-music", "mobile-apps", "stripbooks", "english-books", "popular", "classical",
                "dvd", "videogames", "software", "computers", "electronics", "office-products", "kitchen", "pets", "hpc", "beauty", "food-beverage", "baby"
                , "fashion", "fashion-womens", "fashion-mens", "fashion-baby-kids", "apparel", "shoes", "watch", "jewelry", "toys", "hobby", "mi", "sproting",
                "automotive", "diy", "appliances", "financial", "gift-cards", "industrial", "warehouse-deals"
        };
        String[] category_jp = {
                "セール", "Audible・オーディオブック", "", ""
        };


    }
}
