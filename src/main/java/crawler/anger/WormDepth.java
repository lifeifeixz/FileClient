package crawler.anger;

import crawler.jasiel.Container;
import org.jsoup.Jsoup;
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
    @AutoWired
    private Container resourcesContainer;
    @AutoWired
    private FollowUpOperation operation;
    @AutoWired
    private QualifiedProduct qualifiedProduct;
    @AutoWired
    private FetchResource fetchResource;

    @Override
    public void grab() {
        String url = resourcesContainer.next();
        Document document;
        try {
            document = Jsoup.parse(fetchResource.getPageSource(url, "UTF-8"));
            /*后续处理*/
            Spoils spoils = new Spoils();
            spoils.setUrl(url);
            spoils.setDocument(document);
            spoils.setHeader(null);
            operation.thing(spoils);
            /*收集url。但只收集符合规则的url*/
            Elements links = document.getElementsByTag("a");
            for (Element link : links) {
                String uri = link.attr("abs:href");
                if (qualifiedProduct.verification(uri)) {
                    resourcesContainer.addLink(uri);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resourcesContainer.isNext()) {
                grab();
            }
        }
    }
}
