package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_search_sample;

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
        List<String> category_e = Arrays.asList(
                "amazon-devices", "audible", "diy","dvd","digital-text","software", "instant-video", "mobile-apps", "toy", "gift-cards", "shoes",
                "jewelry", "sports", "dmusic", "hpc", "computers", "beauty", "fashion", "pet-supplies", "baby", "kitchen", "hobby", "music", "appliances",
                "electronics", "classical", "office-products", "apparel", "books", "music-instruments", "english-books", "industrial", "watch", "automotive", "food-beverage"
        );
        List<String> category_jp = Arrays.asList(
                "Amazonデバイス", "Audible・オーディオブック", "DIY・工具・ガーデン", "DVD", "Kindleストア", "PCソフト", "Prime Video", "アプリ&ゲーム",
                "おもちゃ", "ギフト券", "ゲーム",  "シューズ&バッグ", "ジュエリー", "スポーツ&アウトドア", "デジタルミュージック", "ドラッグストア", "パソコン・周辺機器",
                "ビューティー", "ペット用品", "ベビー・マタニティー", "ホーム&キッチン", "ホビー", "ミュージック", "大型家電", "家電＆カメラ", "文房具・オフィス用品",
                "服&ファッション小物",  "本", "楽器・音響機器", "洋書", "産業・研究開発品" , "腕時計", "車&バイク", "食品・飲料・お酒"
        );
        System.out.println("調べたいカテゴリーの番号を選んでください"+"\n");
        for(int i=0; i<category_jp.size(); i++) {
            System.out.println((i+1)+":"+category_jp.get(i));
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        int index = Integer.parseInt(num)-1;
        category = category_e.get(index);
        System.out.println("選ばれたカテゴリーは"+category_jp.get(index)+"です");

        return category;
    }
}
