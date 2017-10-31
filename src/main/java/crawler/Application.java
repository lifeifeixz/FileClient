package crawler;

import crawler.jasiel.ApplicationImpl;
import crawler.jasiel.ApplicationTemplate;

/**
 * Created by flysLi on 2017/10/23.
 */
@SuppressWarnings("all")
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationTemplate applicationTemplate = new ApplicationImpl();
        applicationTemplate.run();
    }
}
