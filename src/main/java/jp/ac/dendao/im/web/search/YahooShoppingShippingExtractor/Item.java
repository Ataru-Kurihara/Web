package jp.ac.dendao.im.web.search.YahooShoppingShippingExtractor;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.io.FileInputStream;
import java.io.InputStream;

public class Item {
    private String title;
    private String link;
    private String description;
    public Item(String title, String link,String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "Item{" +
                "title='" + getTitle() + '\'' +
                ", link='" + getLink() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}