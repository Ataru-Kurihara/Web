package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class amazon {
    private String no1;
    public amazon() {
    }
    public amazon(String no1){
        this.no1 = no1;
    }
    public String getName() throws IOException {
        setCategory category = new setCategory();
        //String urlString = "https://www.amazon.co.jp/gp/bestsellers/dvd/ref=zg_bs_nav_0";
        String urlString = "https://www.amazon.co.jp/gp/bestsellers/" + category.setCategory() + "/ref=zg_bs_nav_0";
        Document doc = Jsoup.connect(urlString).data("q", "java").get();
        Elements elements = doc.select(".zg-item-immersion");
        no1 = elements.get(0).text();
        String regex1 = "#1";
        String newNo1 = no1.replaceAll(regex1, "");
        Pattern p = Pattern.compile(".*5つ星のうち");
        Matcher matcher = p.matcher(newNo1);
        String ItemName;
        while (matcher.find()) {
                newNo1 = matcher.group();
                ItemName = newNo1.replaceAll("5つ星のうち", " ");
                return ItemName;
        }
        return null;
    }

}



