package crawler.jasiel;

import crawler.jasiel.strategy.StorageStrategy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by flysLi on 2017/10/26.
 * 当前线程做的事情就是得到一个link，然后收集内部的超链接
 */
@SuppressWarnings("all")
public class CrawlerAuther {
    private Document document;
    /**
     * 输出策略
     */
    private StorageStrategy storageStrategy;

    public CrawlerAuther(Document document, StorageStrategy storageStrategy) {
        this.document = document;
        this.storageStrategy = storageStrategy;
    }

    /**
     * 仓库
     **/
    private ResourcesContainer resourcesContainer = ResourcesContainer.getInstance();

    public void run() {
        analysisElements(document.getElementsByTag("a"));
    }

    /**
     * 收集指定元素
     *
     * @param elements
     * @return
     */
    public void analysisElements(Elements elements) {
        // 排除未访问和已访问中的该记录
        for (Element element : elements) {
            String href = element.attr("abs:href");
            resourcesContainer.addLink(href);
            //存储
            storageStrategy.save(element.text(), href);
        }
    }

}
