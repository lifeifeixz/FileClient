package crawler.jasiel.strategy;

import org.jsoup.nodes.Element;

/**
 * @author flysLi
 * @date 2017/10/24
 */
public interface StrategyFilter {

    /**
     * 数据过滤策略
     *
     * @param element 元素
     * @return 如果元素符合过滤要求，将反馈true
     */
    boolean filter(Element element);
}
