package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class setCategory {
    private String category;
    public setCategory(){
    }
    public  setCategory(String category) {
        this.category = category;
    }
    public String setCategory() throws IOException {
        String url = "https://www.amazon.co.jp/gp/bestsellers/ref=zg_bs_unv_d_0_d_1";
        Document document = Jsoup.connect(url).data("q","java").get();
        Elements elements = document.select("_p13n-zg-nav-tree-all_style_zg-browse-root__-jwNv, _p13n-zg-nav-tree-all_style_zg-root-browse-item__2WmBB _p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL");
        category = elements.get(0).text();
//        System.out.println("[software,dvd,mobile-apps]の中から1つを入力してください：");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String category = reader.readLine();
//        if (category.length() < 1) {
//            category = "none";
//        }

        return category;
    }
}
