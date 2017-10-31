package crawler.jasiel.strategy;


import org.jsoup.nodes.Document;

/**
 * Created by flysLi on 2017/10/26.
 * 存储策略
 */
public interface StorageStrategy {
    void save(String title, String uri);
    boolean save(Document document);
}
