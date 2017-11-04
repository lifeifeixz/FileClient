package crawler.impl;

import crawler.test.AbstractCrawler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

/**
 * @author flysLi
 * @date 2017/10/23
 */
public class CrawlerImpl extends AbstractCrawler {
    @Override
    protected List<Element> analysis(Document document) {
        //获取所有A标签
        return document.getElementsByTag("a");
    }
}
