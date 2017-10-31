package crawler.jasiel;

import crawler.jasiel.entity.Source;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by flysLi on 2017/10/26.
 */
public class RedisClient {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("106.14.26.20", 6379);
        System.out.println("连接成功");
        //存储数据到列表中
        Source source = new Source();

        Map<String, String> map = new HashMap<>();
        map.put("keyWord", "关键字");
        map.put("url", "http://www.sina.com.cn");
        map.put("description", "详细说明");
        jedis.hmset("新浪网", map);
        // 获取存储的数据并输出
//        List<String> list = jedis.lrange("新浪网", 0, 2);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("列表项为: " + list.get(i));
//        }
    }

    public void save(Source source) {

    }
}
