package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class getRank {
    private String rank;
    public getRank() {
    }
    public getRank(String rank) {
        this.rank = rank;
    }
    public String getRank() throws IOException {
        System.out.println("1位から10位の商品で気になる商品の順位を入力してください");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        if (rank.length() < 1) {
            rank = "none";
        }
        return rank;
    }
}
