package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPlay {
    public static void main(String[] args) throws IOException {
        amazon a = new amazon();
        getRank ranks = new getRank();
        String new_s = null;
        
        List<String> items = a.getItemName();
        for(String s:items){
            Pattern p = Pattern.compile(".*5つ星のうち");
            Matcher matcher = p.matcher(s);
            while (matcher.find()) {
                s = matcher.group();
                new_s = s.replaceAll("5つ星のうち", "");
            }
            System.out.println(new_s);

        }
        int rank = Integer.parseInt(ranks.getRank())-1;
        String regex = "#[0-10]";
        String item = items.get(rank);
        Pattern p = Pattern.compile(".*5つ星のうち");
        Matcher matcher = p.matcher(item);
        String new_item = null;
        while (matcher.find()) {
            item = matcher.group();
            new_item = item.replaceAll("5つ星のうち", "");
            new_item = new_item.replaceAll(regex,"");
        }
        System.out.println(new_item);

    }
}
