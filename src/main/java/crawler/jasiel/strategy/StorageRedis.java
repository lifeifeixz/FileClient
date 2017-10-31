package crawler.jasiel.strategy;

import java.util.Map;

import org.jsoup.nodes.Document;

/**
 * 将公用的逻辑交由父类去完成:比如:获取redis链接、处理dom...
 * 在这里只关心自己需要负责的逻辑
 *
 * @author flysLi
 * @date 2017/10/26
 */
@SuppressWarnings("all")
public class StorageRedis extends AbstractRedisStrategy {
    @Override
    public boolean save(Document document) {
        Map<String, String> map = this.formatMap(document);
        if (map != null) {
            this.getJedis().hmset("title", map);
            return true;
        }
        return false;
    }

    @Override
    public void save(String title, String uri) {
        this.getJedis().set(title, uri);
    }
}
