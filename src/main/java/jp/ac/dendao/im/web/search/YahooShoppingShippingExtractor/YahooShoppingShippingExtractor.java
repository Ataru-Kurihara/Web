package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class YahooShoppingShippingExtractor {
	public static void main(String[] args) {
		System.setProperty("https.protocols", "TLSv1.2");
        String filename = "https://store.shopping.yahoo.co.jp/nomimon/10003093.html";
        try {
			URL url = new URL(filename);
			
			URLConnection connection = url.openConnection();
			
			connection.connect();
			
			InputStream inputStream = connection.getInputStream();
			
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			
			BufferedReader reader = new BufferedReader(inputStreamReader);
			
			String line;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
//				if(line.contains("＋送料") || line.contains("送料無料")) {
//					count = count + 1;
//					System.out.println((line));
//				}
			}
			if (count == 0) {
				System.out.println("送料の情報がありません");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println(filename + "見つかりませんでした");
		} catch (IOException e) {
			System.out.println(e);
		}
    }
}

