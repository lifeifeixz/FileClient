package crawler.jasiel.strategy;

import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;

/**
 * @author flysLi
 * @date 2017/10/26
 */
@SuppressWarnings("all")
public class StorageRedis implements StorageStrategy {
    @Override
    public boolean save(Document document) {
        if (document != null) {
            Elements elements = document.getElementsByTag("title");
            if (elements.size() > 0) {
                String title = elements.get(0).text();
                Jedis jedis = new Jedis("localhost", 6380);
                Map<String, String> map = new HashMap<>();
                map.put(title, document.toString());
                jedis.hmset("title", map);
            }
        }
        return true;
    }

    public void save(Document document, String uri) {
        if (document != null) {
            Elements elements = document.getElementsByTag("title");
            if (elements.size() > 0) {
                String title = elements.get(0).text();
                Jedis jedis = new Jedis("localhost", 6380);
                jedis.hdel(title, uri);
            }
        }
    }

    @Override
    public void save(String title, String uri) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set(title, uri);

    }

    public static void main(String[] args) {
        StorageStrategy redis = new StorageRedis();
        redis.save("asd", "http://asda");
    }
}
