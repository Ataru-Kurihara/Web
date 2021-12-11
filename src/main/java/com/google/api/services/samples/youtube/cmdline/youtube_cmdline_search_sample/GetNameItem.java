package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_search_sample;

import org.jsoup.Jsoup;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetNameItem {
    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        String urlString = "https://www.amazon.co.jp/gp/bestsellers/dvd";
        try {
            URL url = new URL(urlString);
            Document document = (Document) Jsoup.connect(urlString).get();
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);

            Pattern pattern = Pattern.compile("data-ylk=\"slk:txt;pos:1;stid:bobattapioca;item:mskcs50;itemnm:()cicibella;pcatid:43102;price:389;ship:1;\">");
            String line;
            while ((line=reader.readLine()) != null) {
                System.out.println(line);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String text = matcher.group(1);
                    //System.out.println(text);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
