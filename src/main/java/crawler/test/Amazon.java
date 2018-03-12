package crawler.test;

import jars.ResourceTransportationUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Random;

/**
 * Created by flysLi on 2017/10/30.
 */
public class Amazon {
    public static void main(String[] args) throws Exception {
        Document dom = Jsoup.parse(ResourceTransportationUtil.reader("D:\\L临时数据\\HTML\\amazonIndex.txt"));
        Elements links = dom.getElementsByTag("link");
        for (Element link : links) {
            String href = link.attr("href");
            if (href.indexOf("http") > -1) {
                ResourceTransportationUtil.writer(ResourceTransportationUtil.readLocalResource(href), "D:\\L临时数据\\HTML\\" + new Random().nextInt() + ".css");
                System.out.println("done");
            }
        }
    }
}
