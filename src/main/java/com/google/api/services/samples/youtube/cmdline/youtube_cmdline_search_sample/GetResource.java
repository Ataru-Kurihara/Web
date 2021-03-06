package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_search_sample;


import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetResource {
    private static final String PROPERTIES_FILENAME = "youtube.properties";
    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;
    private static YouTube youtube;
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            InputStream in = YouTube.Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);

        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }

        try {
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-search-sample").build();

            // Prompt the user to enter a query term.
            String queryTerm = getInputQuery();

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests. See:
            // {{ https://cloud.google.com/console }}
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            search.setQ(queryTerm);

            // Restrict the search results to only include videos. See:
            // https://developers.google.com/youtube/v3/docs/search/list#type
            search.setType("video");

            // To increase efficiency, only retrieve the fields that the
            // application uses.
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url, snippet/channelId, snippet/channelTitle)");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
                prettyPrint(searchResultList.iterator(), queryTerm);
            }
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static String getInputQuery() throws IOException {
//        amazon a = new amazon();
//        String inputQuery = String.valueOf(a.getItemName());//bReader.readLine();
//        if (inputQuery.length() < 1) {
//            // Use the string "YouTube Developers Live" as a default.
//            inputQuery = "YouTube Developers Live";
//        }
//        return inputQuery;
        amazon a = new amazon();
        getRank ranks = new getRank();
        String new_item = null;
        List<String> items = a.getItemName();
        for(String s:items){
            Pattern p = Pattern.compile(".*5???????????????");
            Matcher matcher = p.matcher(s);
            while (matcher.find()) {
                s = matcher.group();
                s = s.replaceAll("5???????????????", "");
            }
            System.out.println(s);
        }
        int rank = Integer.parseInt(ranks.getRank())-1;
        String regex = "#[0-50]";
        String item = items.get(rank);
        Pattern p = Pattern.compile(".*5???????????????");
        Matcher matcher = p.matcher(item);
        while (matcher.find()) {
            item = matcher.group();
            new_item = item.replaceAll("5???????????????", "");
            new_item = new_item.replaceAll(regex,"");

        }
        return new_item;
    }

    private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) throws InterruptedException, IOException {

        System.out.println("\n=============================================================");
        System.out.println(
                " ????????????????????? \"" + query + "\"?????????");
        System.out.println("??????????????????"+NUMBER_OF_VIDEOS_RETURNED+"?????????????????????????????????");
        System.out.println("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            System.out.println(" There aren't any results for your query.");
        }
        Thread.sleep(3000);
        YouTube.Videos.List list = youtube.videos().list("statistics");
        Video v = list.execute().getItems().get(0);
        while (iteratorSearchResults.hasNext()) {
            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();
            if (rId.getKind().equals("youtube#video")) {
                System.out.println("???????????????URL???"+"http://www.youtube.com/channel/"+singleVideo.getSnippet().getChannelId());
                System.out.println("?????????????????????"+singleVideo.getSnippet().getChannelTitle());
                System.out.println("??????URL???" + "http://www.youtube.com/watch?v=" + rId.getVideoId());
                System.out.println("?????????????????????" + singleVideo.getSnippet().getTitle());
                System.out.println(v.getStatistics().getViewCount());
                System.out.println("------------------------------------------------");

            }else {
                System.out.println("???????????????????????????????????????....");
            }
        }
    }

}