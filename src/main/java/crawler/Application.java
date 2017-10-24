package crawler;

import crawler.impl.CrawlerImpl;

/**
 * Created by flysLi on 2017/10/23.
 */
public class Application {
    public static void main(String[] args) {
        AbstractCrawler crawler = new CrawlerImpl();

        crawler.execute("http://www.sina.com.cn/");
    }
}
