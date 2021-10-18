package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
	// 名前、価格、送料
		private String name;
		private int price;
		private int shipping;
		// コンストラクタ
		public App(String urlString) {
			fetch(urlString);
		}
		// fetchメソッド
		public void fetch(String urlString) {
			try {
				URL url = new URL(urlString);
				URLConnection connection = url.openConnection();
				connection.connect();
				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader reader = new BufferedReader(inputStreamReader);
				
				Pattern pattern = Pattern.compile("送料([0-9,]+)円(title)(price)");

				int shipping = -1;

				String line;
				while((line = reader.readLine()) != null) {
					Matcher matcher = pattern.matcher(line);
					if(matcher.find()) {
						String numberString = matcher.group(1);
						try {
							Number number = NumberFormat.getInstance().parse(numberString);
							shipping = number.intValue();
							break;
						} catch (ParseException e) {
							System.out.println("数値のフォーマットに適合しません:"+numberString);
						}
					}
					else if(line.contains("送料無料")) {
						shipping = 0;
					}
				}
				reader.close();
				if(shipping > 0) {
					System.out.println("送料は、"+NumberFormat.getInstance().format(shipping)+"円です。");
				}
				else if(shipping == 0) {
					System.out.println("送料は無料っぽいです");
				}
				else {
					System.out.println("送料に関する情報がありません。");
				}
			} catch(IOException e ) {
				System.out.println(e);
			}
		}
		public static void main(String[] args) {
			System.setProperty("https.protocols","TLSv1,TLSv1.1,TLSv1.2");
			//ここで複数商品をデモする
			ArrayList<YahooShoppingItem> itemList = new ArrayList<YahooShoppingItem>();
			YahooShoppingItem item = new YahooShoppingItem("https://store.shopping.yahoo.co.jp/soukai/623922500016.html");
			item = new YahooShoppingItem("https://store.shopping.yahoo.co.jp/nomimon/10003093.html");
			for (int i=0; i < itemList.size(); i++) {
				itemList.add(item);
			}
		}
}
