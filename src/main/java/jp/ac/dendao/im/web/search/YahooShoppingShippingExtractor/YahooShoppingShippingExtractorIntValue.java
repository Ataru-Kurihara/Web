package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YahooShoppingShippingExtractorIntValue {
	public static void main(String[] args) {
		NumberFormat nfNum = NumberFormat.getNumberInstance();
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		try {
			URL url = new URL("https://store.shopping.yahoo.co.jp/igenso/d1183-usb-red-s.html?sc_i=shp_pc_top_sales_item_1_1");
			URLConnection connection = url.openConnection();
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader reader = new BufferedReader(inputStreamReader);
			

			Pattern pattern = Pattern.compile("送料(\\d{3,})");
			Pattern pattern1 = Pattern.compile("送料無料");
			String line;
			String message = "送料情報がありません";
			int n = 10;
			while((line = reader.readLine()) != null) {
				//System.out.println(line);
				Matcher matcher = pattern.matcher(line);
				Matcher matcher1 = pattern1.matcher(line);
				if(matcher.find()) {
					String numberString = matcher.group(1);
					Number number = NumberFormat.getInstance().parse(numberString);
					n = number.intValue();
					
				}
				if (matcher1.find()) {
					String FreeDerivary = matcher1.group();
					message = FreeDerivary;
					if (message.equals("送料無料")) {
						n = 0;
					}
					else {
						n = -1;
					}
				}
			}

			reader.close();
			System.out.println(nfNum.format(n));
			
		} catch(IOException e) {
			System.out.println(e);
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}

}
