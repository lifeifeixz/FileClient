package crawler.jasiel.strategy;

import org.jsoup.select.Elements;

/**
 * @author flysLi
 * @date 2017/11/1
 * 收集策略
 */
public interface CollectStrategy {

    void analysisElements(Elements elements);
}
