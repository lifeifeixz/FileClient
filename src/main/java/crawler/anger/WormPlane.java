package crawler.anger;

import crawler.jasiel.Container;
import crawler.jasiel.ResourcesContainer;
import org.jsoup.nodes.Document;

/**
 * 平面抓取
 *
 * @author flysLi
 * @date 2018/3/19
 */
public class WormPlane implements Worm {
    @AutoWired
    private Container resourcesContainer;
    @AutoWired
    private FollowUpOperation operation;
    @AutoWired
    private FetchResource fetchResource;

    @Override
    public void grab() {
        while (resourcesContainer.isNext()) {
            String url = resourcesContainer.next();
            Document document;
            try {
                document = fetchResource.get(url);
                /*交给后续*/
                Spoils spoils = new Spoils();
                spoils.setUrl(url);
                spoils.setDocument(document);
                spoils.setHeader(null);
                operation.thing(spoils);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
