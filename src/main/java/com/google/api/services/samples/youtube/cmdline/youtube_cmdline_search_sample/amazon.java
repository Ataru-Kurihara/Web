package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_search_sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class amazon {
    private String item;
    private String category;
    public amazon() {
        super();
    }
    public amazon(String item, String category){
        this.item = item;
        this.category = category;
    }
    public List<String> getItemName() throws IOException {
        setCategory category = new setCategory();
        String urlString = "https://www.amazon.co.jp/gp/bestsellers/" + category.getCategory() + "/ref=zg_bs_nav_0";
        Document doc = Jsoup.connect(urlString).data("q", "java").get();
        Elements elements = doc.select(".zg-item-immersion");
        List<String> items = new ArrayList<String>(10);
        for (org.jsoup.nodes.Element element : elements) {
            items.add(element.text());
        }
        return items;
    }

}



