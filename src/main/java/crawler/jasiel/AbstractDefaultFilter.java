package crawler.jasiel;

import crawler.jasiel.strategy.StrategyFilter;
import org.jsoup.nodes.Element;

/**
 * @author flysLi
 * @date 2017/11/4
 */
public class AbstractDefaultFilter implements StrategyFilter {
    @Override
    public boolean filter(Element element) {
        return false;
    }
}
