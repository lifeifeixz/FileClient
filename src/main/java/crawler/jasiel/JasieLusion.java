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
    private ResourcesContainer resourcesContainer = ResourcesContainer.getInstance();
    private StrategyFilter strategyFilter;
    private AnalysisStrategy analysisStrategy;

    public void setStorageStrategy(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public void setAnalysisStrategy(AnalysisStrategy analysisStrategy) {
        this.analysisStrategy = analysisStrategy;
    }

    public JasieLusion(String uri) {
        //实例化构造条件
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
            new CrawlerAuther(storageStrategy).ahalysis(document);
        } catch (Exception e) {
            System.out.println(link + "[抓取不到]" + e.getMessage());
        }
        if (!resourcesContainer.isNext()) {
            crawler();
        }
    }
}
