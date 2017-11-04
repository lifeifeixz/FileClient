package crawler.jasiel;

import crawler.jasiel.strategy.StrategyFilter;
import org.jsoup.nodes.Element;

/**
 * 文本过滤
 *
 * @author flysLi
 * @date 2017/10/24
 */
public class TextFilter implements StrategyFilter {
    private String keyWord;

    /**
     * 构造该对象时，传入筛选关键字
     *
     * @param keyWord
     */
    public TextFilter(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public boolean filter(Element element) {
        if (element.text().indexOf(keyWord) > -1) {
            return true;
        }
        return false;
    }
}
