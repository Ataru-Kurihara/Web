package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class amazon {
    private List<String> items = new ArrayList<String>();
    private String category;
    public amazon() {
        super();
    }
    public amazon(String[] items, String category){
        this.items = Arrays.asList(items);
        this.category = category;
    }
    public List<String> getItemName() throws IOException {
        setCategory category = new setCategory();
        String urlString = "https://www.amazon.co.jp/gp/bestsellers/" + category.getCategory() + "/ref=zg_bs_nav_0";
        Document doc = Jsoup.connect(urlString).data("q", "java").get();
        Elements elements = doc.select(".zg-item-immersion");
        for (int i=0; i<10; i++) {
           items.add(elements.get(i).text());
        }
        for (String item: items) {
            Pattern p = Pattern.compile(".*5つ星のうち");
            Matcher matcher = p.matcher(item);
        }
//        String regex1 = "#"+category.getRank();
//        String newNo1 = no1.replaceAll(regex1, "");
//        Pattern p = Pattern.compile(".*5つ星のうち");
//        Matcher matcher = p.matcher(newNo1);
//        String ItemName;
//        while (matcher.find()) {
//                newNo1 = matcher.group();
//                ItemName = newNo1.replaceAll("5つ星のうち", " ");
//                return ItemName;
//        }
        return items;
    }
    public String getCategory() throws IOException{
        String urlString = "https://www.amazon.co.jp/gp/goldbox?ref_=nav_cs_gb";
        Document doc = Jsoup.connect(urlString).data("q", "java").get();
        category = doc.html();
        return category;
//        35

    }
}



