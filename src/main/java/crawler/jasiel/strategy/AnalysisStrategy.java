package crawler.jasiel.strategy;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author flysLi
 * @date 2017/10/31
 */
public interface AnalysisStrategy {

    /**
     * 解析标准
     *
     * @param document
     * @return
     */
    Elements ahalysis(Document document);
}
