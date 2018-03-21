package crawler.anger;

import org.jsoup.nodes.Document;

/**
 * 资源的获取方式规范
 *
 * @author flysLi
 * @date 2018/3/20
 */
public interface FetchResource {

    /**
     * 获取dom的方式
     *
     * @param uri
     * @return
     */
    Document get(String uri) throws Exception;

    /**
     * 获取string类型的资源
     *
     * @param pageUrl
     * @param encoding
     * @return
     */
    String getPageSource(String pageUrl, String encoding);
}
