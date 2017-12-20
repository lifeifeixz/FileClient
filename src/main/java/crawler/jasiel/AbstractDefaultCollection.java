package crawler.jasiel;

import crawler.jasiel.strategy.CollectionStrategy;

/**
 * @author flysLi
 * @date 2017/11/4
 */
public class AbstractDefaultCollection implements CollectionStrategy {
    @Override
    public boolean filter(String uri) {

        return true;
    }
}
