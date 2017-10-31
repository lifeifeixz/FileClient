package crawler.jasiel.strategy;

import org.jsoup.nodes.Document;

/**
 * Created by flysLi on 2017/10/27.
 * 打印策略
 */
public class StroragePrint implements StorageStrategy {
    public void save(Document document) {
        System.out.println(document.getElementsByTag("title").get(0).text());
    }

    @Override
    public void save(String title, String uri) {

    }
}
