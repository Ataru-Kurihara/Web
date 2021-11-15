package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_search_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class GetNameItem {
    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        String urlString = "https://shopping.yahoo.co.jp/ranking/?sc_i=shp_pc_top_sideMenuTheme_10";
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);

            Pattern pattern = Pattern.compile("(https://shopping.yahoo.co.jp/category/13457/ranking/?sc_i=shp_pc_ranking-top_mdSideListCategory_01)+");
            System.out.println(pattern);
            String line;
//            while ((line=reader.readLine()) != null) {
//                System.out.println(line);
//            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
