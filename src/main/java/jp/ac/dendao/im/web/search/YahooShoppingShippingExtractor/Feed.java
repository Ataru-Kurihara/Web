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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Feed {
    public Feed(String urlString, String encoding) {
        InputStream inputStream = new ByteArrayInputStream(urlString.getBytes(StandardCharsets.UTF_8));
        buildDocument(inputStream,encoding);
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
    public Item showTree(Node node) {
        for(Node current = node.getFirstChild();
            current != null;
            current = current.getNextSibling()) {
            if (current.getNodeType() == Node.ELEMENT_NODE) {
                String nodeName = current.getNodeName();
                System.out.println(nodeName + " {");
                showTree(current);
                System.out.println("}");
            }
            else if(current.getNodeType() == Node.TEXT_NODE && current.getNodeValue().trim().length() != 0) {
                System.out.println(current.getNodeValue());
            }
            else if(current.getNodeType() == Node.CDATA_SECTION_NODE) {
                System.out.println(current.getNodeValue());
            }
        }
        return null;
    }
    public ArrayList<Item> getItemList() {
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();

            Document document = null;
            NodeList itemNodeList = (NodeList) xPath.evaluate("/rss/channel/item", document, XPathConstants.NODESET);
//            if (itemNodeList.getLength()==0) {
//                itemNodeList = (NodeList)xPath.evaluate("/RDF/item",document, XPathConstants.NODESET);
//            }
            for (int i=0; i<itemNodeList.getLength(); i++) {
                itemList.add(showTree(itemNodeList.item(i)));
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
        Feed feed = new Feed("https://news.yahoo.co.jp/rss/topics/it.xml","enc-jp");
//        Document document = feed.buildDocument(inputStream, "enc-jp");
        ArrayList<Item> itemList = feed.getItemList();
        for (Item item : itemList) {
            System.out.println(item);
        }
    }
}
