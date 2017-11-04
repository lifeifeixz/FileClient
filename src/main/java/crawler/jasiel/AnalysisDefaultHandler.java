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
public class AnalysisDefaultHandler implements AnalysisStrategy {
    private StorageStrategy strorageDefault = new AbstractDefaultStrorage();
    private Container container = ResourcesContainer.getInstance();
    private CollectionStrategy collectionStrategy = new AbstractDefaultCollection();

    public AnalysisDefaultHandler() {
    }

    public AnalysisDefaultHandler(Object... objects) {
    }

    @Override
    public Elements ahalysis(Document document) {
        Elements elements = document.getElementsByTag("a");
        for (Element element : elements) {
            String href = element.attr("abs:href");
            //收集策略
            container.addLink(href);
            //输出策略
            strorageDefault.save(element.text(), href);
        }
        return null;
    }

    @Override
    public void setStorageStrategy(StorageStrategy storageStrategy) {

    }
}
