package crawler.jasiel.strategy;

import org.jsoup.nodes.Document;

/**
 * Created by flysLi on 2017/10/27.
 * 打印策略
 */
public class StroragePrint implements StorageStrategy {
    @Override
    public boolean save(Document document) {
        System.out.println(document.getElementsByTag("title").get(0).text());
        return false;
    }

    @Override
    public void save(String title, String uri) {
        System.out.println(title + "----------" + uri);
    }
}
