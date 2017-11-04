package crawler.jasiel.strategy;

/**
 * @author flysLi
 * @date 2017/11/4
 * url的收集策略
 */
public interface CollectionStrategy {
    boolean filter(String uri);
}
