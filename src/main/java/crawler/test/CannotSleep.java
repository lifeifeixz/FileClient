package crawler.test;

import jars.ResourceTransportationUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author flysLi
 * @date 2018/1/30
 */
public class CannotSleep {
    public static final int COUNT = 100;
    private int start;
    private int end;

    public CannotSleep(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public static void main(String[] args) throws Exception {
        CannotSleep sleep = new CannotSleep(38, 100);
        sleep.collot(null);
    }

    /**
     * 抓取
     *
     * @param baseUri
     * @throws Exception
     */
    public void collot(String baseUri) {
        for (int i = this.start; i <= this.end; i++) {
            Document dom = null;
            try {
                dom = ResourceTransportationUtil.get("http://aqdybf.com/lusi/index" + i + ".html", "GBK");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //取出contents
            Elements links = dom.getElementsByClass("play-pic");
            for (Element link : links) {
                //超链接
                String uri = link.attr("abs:href");
                //图片
                Element img = link.getElementsByTag("img").first();
                //图片名称
                String name = img.attr("alt");
                //图片地址
                String imgAddress = img.attr("abs:src");
                //下载图片
                try {
                    ResourceTransportationUtil.download(imgAddress, name + ".jpg", new File("D:\\L临时数据\\cannotSleep"));
                } catch (Exception e) {
                    System.out.println("保存文件时出现异常[" + name + "]");
                }
            }
            System.out.println(i);
        }
    }
}
