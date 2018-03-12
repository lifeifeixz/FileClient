package crawler.test;

import jars.ResourceTransportationUtil;
import org.jsoup.nodes.Document;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class QqZone {
    public static void main(String[] args) throws Exception {
        Document dom = ResourceTransportationUtil.get("https://www.autohome.com.cn/car/#pvareaid=101452", "GBK");
        System.out.println(dom.toString());
    }
}
