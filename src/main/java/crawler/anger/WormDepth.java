package crawler.anger;

import crawler.jasiel.Container;
import crawler.jasiel.ResourcesContainer;
import jars.ResourceTransportationUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 这条虫子使用深度抓取方式
 *
 * @author flysLi
 * @date 2018/3/19
 */
public class WormDepth implements Worm {
    private Container resourcesContainer = ResourcesContainer.getInstance();
    @AutoWired
    private FollowUpOperation operation;
    @AutoWired
    private QualifiedProduct qualifiedProduct;

    @Override
    public void grab() {
        String url = resourcesContainer.next();
        Document document;
        try {
            document = ResourceTransportationUtil.get(url);
            /*后续处理*/
            Spoils spoils = new Spoils();
            spoils.setUrl(url);
            spoils.setDocument(document);
            spoils.setHeader(null);
            operation.thing(spoils);
            /*收集url。但只收集符合规则的url*/
            Elements links = document.getElementsByTag("a");
            for (Element link : links) {
                String uri = link.attr("href");
                if (qualifiedProduct.verification(uri)) {
                    resourcesContainer.addLink(uri);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!resourcesContainer.isNext()) {
                grab();
            }
        }
    }
}
