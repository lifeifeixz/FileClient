package crawler.jasiel.strategy;

import org.jsoup.nodes.Element;

/**
 * @author flysLi
 * @date 2017/11/4
 */
public class DefaultFilter implements StrategyFilter {
    @Override
    public boolean filter(Element element) {
        return false;
    }
}
