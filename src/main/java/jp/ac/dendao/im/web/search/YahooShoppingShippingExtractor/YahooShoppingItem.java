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

public class YahooShoppingItem {
	// 名前、価格、送料
	private String name;
	private int price;
	private int shipping;
	// コンストラクタ
	public YahooShoppingItem(String urlString) {
		fetch(urlString);
	}
	// fetchメソッド
	public void fetch(String urlString) {
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		try {
			// URLオブジェクトを生成
			URL url = new URL(urlString);  
			// URLオブジェクトから、接続にいくURLConnectionオブジェクトを取得
			URLConnection connection = url.openConnection();
			// 接続
			connection.connect();
			// サーバからやってくるデータをInputStreamとして取得
			InputStream inputStream = connection.getInputStream();
			// 次に inputStream を読み込む InputStreamReader のインスタンス inputStreamReader を生成
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			// さらに inputStreamReader をラップする BufferedReader のインスタンス reader を生成
			BufferedReader reader = new BufferedReader(inputStreamReader);
			//BufferedReader reader = new BufferedReader(new FileReader(filename));

	        Pattern pattern = Pattern.compile("送料([0-9,]+)円");  // グループの指定が1つ(1番目)
	        shipping = -1;  // 送料 (見つからなかったら -1 のまま)

			String line;
			while ((line = reader.readLine()) != null) {		// readLine() が null (=ページ終端) でない間
		        Matcher matcher = pattern.matcher(line);
		        if(matcher.find()) {  // パターンにマッチしたら
		            String numberString = matcher.group(1);   // 1番目のグループにマッチした文字列を取り出す
			        try {
			            Number number = NumberFormat.getInstance().parse(numberString);
			            shipping = number.intValue();
			        } catch (ParseException e) {
			            System.err.println("数値のフォーマットに適合しません: " + numberString);
			        }
		        }
				else if(line.contains("送料無料")) {
					shipping = 0;   // 「合計10,000円以上で送料無料」とかあるので自信なし
					// この後に明確な送料の記述があるかもしれないので break しない
				}
		        Pattern pattern2 = Pattern.compile("<li><strong><span>(.+)</span></strong></li>");
		        Matcher matcher2 = pattern2.matcher(line);
		        if (matcher2.find()) {
		        	String titleString = matcher2.group(1);
		        	name = titleString;
		        }
		        Pattern pattern3 = Pattern.compile("<span class=\"elPriceValue\">([0-9,]+)円");
		        Matcher matcher3 = pattern3.matcher(line);
		        if (matcher3.find()) {
		        	String priceString = matcher3.group(1);
			        try {
			            Number number = NumberFormat.getInstance().parse(priceString);
			            price = number.intValue();
			        } catch (ParseException e) {
			            System.err.println("数値のフォーマットに適合しません: " + priceString);
			        }
		        }
			}
			reader.close();
			System.out.println("価格は、"+price+"円です。");
			System.out.println("商品名は、"+name);
			// 送料に関する情報を表示
			if(shipping > 0) {
				System.out.println("送料は " + NumberFormat.getInstance().format(shipping) + " 円です。");	// 「,」ありで表示
			}
			else if(shipping == 0) {
				System.out.println("送料は無料っぽいです。");
			}
			else {
				System.out.println("送料に関する情報がありません。");
			}
		} catch (IOException e) {
			e.printStackTrace();
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
