package crawler.jasiel;

import crawler.jasiel.strategy.StorageStrategy;
import org.jsoup.nodes.Document;

/**
 * @author flysLi
 * @date 2017/10/27
 * 打印策略
 */
public class AbstractDefaultStrorage implements StorageStrategy {
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
