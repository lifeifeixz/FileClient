package crawler.anger;

import org.jsoup.nodes.Document;

import java.io.Serializable;

/**
 * @author flysLi
 * @date 2018/3/19
 */
public class Spoils implements Serializable {
    private String url;
    private Document document;
    private String header;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
