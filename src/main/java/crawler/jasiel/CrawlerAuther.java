package crawler.jasiel;

import crawler.jasiel.strategy.AnalysisStrategy;
import crawler.jasiel.strategy.StorageStrategy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by flysLi on 2017/10/26.
 * 当前线程做的事情就是得到一个link，然后收集内部的超链接
 */
@SuppressWarnings("all")
public class CrawlerAuther implements AnalysisStrategy {
    private StorageStrategy storageStrategy;
    private ResourcesContainer resourcesContainer = ResourcesContainer.getInstance();

    public CrawlerAuther(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    @Override
    public Elements ahalysis(Document document) {
        Elements elements = document.getElementsByTag("a");
        for (Element element : elements) {
            String href = element.attr("abs:href");
            resourcesContainer.addLink(href);
            //输出
            storageStrategy.save(element.text(), href);
        }
        return null;
    }
}
