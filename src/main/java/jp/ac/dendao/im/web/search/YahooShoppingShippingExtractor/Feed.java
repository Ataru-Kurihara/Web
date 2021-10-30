package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;
import org.w3c.dom.*;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Feed {
    private Document document;
    public Feed(String urlString) {
        ViewDocument(urlString);
    }
    public  void ViewDocument(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            document = buildDocument(inputStream, "utf-8");
            getItemList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //DOMTreeの構築
    public Document buildDocument(InputStream inputStream, String encoding) {
        Document document = null;
        try {
            //DOM実装
            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS implementation = (DOMImplementationLS) registry.getDOMImplementation("XML 1.0");
            //読み込み対象の用意
            LSInput input = implementation.createLSInput();
            input.setByteStream(inputStream);
            input.setEncoding(encoding);
            //構文解析器(parser)の用意
            LSParser parser = implementation.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
            parser.getDomConfig().setParameter("namespaces",false);
            document = parser.parse(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
    public ArrayList<Item> getItemList() {
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();
            NodeList itemNodeList = (NodeList)xPath.evaluate("/rss/channel/item", document, XPathConstants.NODESET);
            if (itemNodeList.getLength() == 0) {
                itemNodeList = (NodeList) xPath.evaluate("/RDF/item", document,XPathConstants.NODESET);
            }
            for (int i=0; i<itemNodeList.getLength(); i++) {
                org.w3c.dom.Node itemNode = itemNodeList.item(i);
                String title = xPath.evaluate("title", itemNode);
                String link = xPath.evaluate("link", itemNode);
                String description = xPath.evaluate("description", itemNode);
                itemList.add(new Item(title, link, description));

            }
        }catch (DOMException e) {
            System.err.println("DOMエラー："+e);
        }catch (XPathExpressionException e) {
            System.err.println("XPath 表現エラー"+e);
        }
        return itemList;
    }
    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        String urlString = "https://news.yahoo.co.jp/rss/topics/it.xml";
        Feed feed = new Feed(urlString);
        ArrayList<Item> itemList = feed.getItemList();
        for (Item item : itemList) {
            System.out.println(item);
            System.out.println();
        }
    }
}
