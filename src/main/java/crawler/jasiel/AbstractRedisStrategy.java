package crawler.jasiel;

import crawler.jasiel.strategy.StorageStrategy;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * 输出策略：redis的实现
 *
 * @author flysLi
 * @date 2017/11/1
 */
@SuppressWarnings("all")
public class AbstractRedisStrategy implements StorageStrategy {

    @Override
    public void save(String title, String uri) {

    }

    @Override
    public boolean save(Document document) {
        return false;
    }

    protected Jedis getJedis() {
        return new Jedis("localhost", 6379);
    }

    protected Map<String, String> formatMap(Document document) {
        if (document != null) {
            Map<String, String> map = new HashMap<>();
            Elements elements = document.getElementsByTag("title");
            if (elements.size() > 0) {
                String title = elements.get(0).text();
                map.put(title, document.toString());
            }
            return map;
        }
        return null;
    }
}
