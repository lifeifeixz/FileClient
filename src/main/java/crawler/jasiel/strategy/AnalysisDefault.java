package crawler.jasiel.strategy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author flysLi
 * @date 2017/10/31
 */
public class AnalysisDefault implements AnalysisStrategy {
    private StorageStrategy storageStrategy;

    public AnalysisDefault(StorageStrategy storageStrategy) {
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
}
