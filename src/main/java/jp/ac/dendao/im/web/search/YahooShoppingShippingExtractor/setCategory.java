package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class setCategory {
    private String category;
    private String rank;
    public setCategory(){
    }
    public  setCategory(String category,String rank) {
        this.category = category;
        this.rank = rank;
    }
    public String getCategory() throws IOException {
        String[] category_e = {
                "todays-deals", "audible", "amazonfresh", "life", "amazon-device", "digital-text", "instant-video"
                , "alexa-skills", "digital-music", "mobile-apps", "stripbooks", "english-books", "popular", "classical",
                "dvd", "videogames", "software", "computers", "electronics", "office-products", "kitchen", "pets", "hpc", "beauty", "food-beverage", "baby"
                , "fashion", "fashion-womens", "fashion-mens", "fashion-baby-kids", "apparel", "shoes", "watch", "jewelry", "toys", "hobby", "mi", "sproting",
                "automotive", "diy", "appliances", "financial", "gift-cards", "industrial", "warehouse-deals"
        };
        String[] category_jp = {
                "セール", "Audible・オーディオブック", "フレッシュ", "ライフ", "Amazonデバイス", "Kindleストア", "PrimeVideo", "Alexaスキル", "デジタルミュージック",
                "Androidアプリ", "本", "洋書", "ミュージック", "クラシック", "DVD", "TVゲーム", "PCソフト", "パソコン・周辺機器", "家電", "文房具", "ホームキッチン", "ペット用品", "ドラッグストア",
                "ビューティー", "食料・飲料・お酒", "ベビー・マタニティー", "ファッション", "レディース", "メンズ",  "キッズ&ベビー", "ファッション小物", "シューズ&バッグ", "腕時計", "ジュエリー", "おもちゃ",
                "",
        };
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String category = reader.readLine();
        if (category.length() < 1) {
            category = "none";
        }
        return category;
    }
    public String getRank() throws IOException {
        System.out.println("1,2,3,4,5,6,7,8,9,10から気になる順位を入力してください");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        if (rank.length() < 1) {
            rank = "1";
        }
        return rank;
    }
}
