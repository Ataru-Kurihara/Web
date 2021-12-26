package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class setCategory {
    private String category;
    public setCategory(){
    }
    public  setCategory(String category) {
        this.category = category;
    }
    public String getCategory() throws IOException {
        List<String> category_e = Arrays.asList("todays-deals", "audible", "amazonfresh", "life", "amazon-device", "digital-text", "instant-video"
                , "alexa-skills", "digital-music", "mobile-apps", "stripbooks", "english-books", "popular", "classical",
                "dvd", "videogames", "software", "computers", "electronics", "office-products", "kitchen", "pets", "hpc", "beauty", "food-beverage", "baby"
                , "fashion", "fashion-womens", "fashion-mens", "fashion-baby-kids", "apparel", "shoes", "watch", "jewelry", "toys", "hobby", "mi", "sproting",
                "automotive", "diy", "appliances", "financial", "gift-cards", "industrial", "warehouse-deals");
        List<String> category_jp = Arrays.asList("セール", "Audible・オーディオブック", "フレッシュ", "ライフ", "Amazonデバイス", "Kindleストア", "PrimeVideo", "Alexaスキル", "デジタルミュージック",
                "Androidアプリ", "本", "洋書", "ミュージック", "クラシック", "DVD", "TVゲーム", "PCソフト", "パソコン・周辺機器", "家電", "文房具", "ホームキッチン", "ペット用品", "ドラッグストア",
                "ビューティー", "食料・飲料・お酒", "ベビー・マタニティー", "ファッション", "レディース", "メンズ", "キッズ&ベビー", "ファッション小物", "シューズ&バッグ", "腕時計", "ジュエリー", "おもちゃ",
                "ホビー", "楽器", "スポーツ&アウトドア", "車&バイク", "DIY・工具・ガーデン", "大型家電", "クレジットカード", "ギフト券", "産業・研究開発品", "Amazonアウトレット");
        System.out.println("調べたいカテゴリーの番号を選んでください"+"\n");
        for(int i=0; i<category_jp.size(); i++) {
            System.out.println((i+1)+":"+category_jp.get(i));
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        int index = Integer.parseInt(num);
        category = category_e.get(index);
        System.out.println("選ばれたカテゴリーは"+category_jp.get(index)+"です");
        return category;
    }
}
