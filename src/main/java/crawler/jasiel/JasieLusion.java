package crawler.jasiel;

import crawler.jasiel.strategy.*;
import crawler.jasiel.util.RemoteReadUtils;
import org.jsoup.nodes.Document;

/**
 * @author flysLi
 * @date 2017/10/23
 */
@SuppressWarnings("all")
public class JasieLusion {
    private StorageStrategy storageStrategy;

    public void setStorageStrategy(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    private ResourcesContainer resourcesContainer = ResourcesContainer.getInstance();
    private StrategyFilter filter;

    public JasieLusion(String uri) {
        //实例化构造条件
        this.filter = filter;
        resourcesContainer.addLink(uri);
    }

    public void start() {
        crawler();
    }

    public void crawler() {
        String link = resourcesContainer.next();
        Document document = null;
        try {
            document = RemoteReadUtils.get(link);
            new CrawlerAuther(document, storageStrategy).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!resourcesContainer.isNext()) {
            crawler();
        }
    }

    public static void main(String[] args) {
        String[] uris = new String[]{"http://www.ifeng.com/", "http://news.qq.com/"};
        for (String uri : uris) {
            new Thread(() -> {
                JasieLusion jasieLusion = new JasieLusion(uri);
                jasieLusion.setStorageStrategy(new StorageRedis());
                jasieLusion.start();
            }).start();
        }
    }
}
