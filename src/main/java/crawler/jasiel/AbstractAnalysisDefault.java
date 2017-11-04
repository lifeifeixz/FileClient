package crawler.jasiel;

import crawler.jasiel.strategy.AnalysisStrategy;
import crawler.jasiel.strategy.StorageStrategy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author flysLi
 * @date 2017/10/31
 */
public class AbstractAnalysisDefault implements AnalysisStrategy {
    private StorageStrategy storageStrategy;

    public AbstractAnalysisDefault(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    @Override
    public Elements ahalysis(Document document) {
        Elements elements = document.getElementsByTag("a");
        for (Element element : elements) {
            String href = element.attr("abs:href");
        }
        return null;
    }

    @Override
    public void setStorageStrategy(StorageStrategy storageStrategy) {

    }
}
