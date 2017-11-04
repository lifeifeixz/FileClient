package crawler.jasiel;

import crawler.jasiel.strategy.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by flysLi on 2017/10/26.
 * 当前线程做的事情就是得到一个link，然后收集内部的超链接
 */
@SuppressWarnings("all")
public class CrawlerAuther implements AnalysisStrategy {
    private StorageStrategy storageStrategy = new StroragePrint();
    private ResourcesContainer resourcesContainer = ResourcesContainer.getInstance();
    private CollectionStrategy collectionStrategy = new CollectionDefault();

    @Override
    public Elements ahalysis(Document document) {
        Elements elements = document.getElementsByTag("a");
        for (Element element : elements) {
            String href = element.attr("abs:href");
            //收集策略
            if (collectionStrategy.filter(href)) {
                resourcesContainer.addLink(href);
            }
            //输出
            storageStrategy.save(element.text(), href);
        }
        return null;
    }
}
