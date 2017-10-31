package crawler;

import crawler.jasiel.JasieLusion;
import crawler.jasiel.strategy.StorageRedis;
import crawler.jasiel.util.RemoteReadUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by flysLi on 2017/10/23.
 */
@SuppressWarnings("all")
public class Application {
    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(RemoteReadUtils.reader("https://www.msn.cn/zh-cn"));
        Elements links = document.getElementsByTag("a");
        for (Element link : links) {
            String uri = link.attr("abs:href");
            if (uri == null || uri.indexOf("http") == -1) {
                continue;
            }
            new Thread(() -> {
                JasieLusion jasieLusion = new JasieLusion(uri);
                jasieLusion.setStorageStrategy(new StorageRedis());
                jasieLusion.start();
            }).start();
        }
        System.out.println("共创建" + links.size() + "个线程");
    }
}
