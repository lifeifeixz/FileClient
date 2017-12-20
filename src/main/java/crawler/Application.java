package crawler;

import crawler.jasiel.ApplicationImpl;
import crawler.jasiel.ApplicationTemplate;
import crawler.jasiel.ResourcesContainer;

/**
 * Created by flysLi on 2017/10/23.
 */
@SuppressWarnings("all")
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationTemplate applicationTemplate = new ApplicationImpl();
        //在仓库中添加一条数据
        ResourcesContainer.getInstance().addLink("https://www.hupu.com");
        applicationTemplate.run();
    }
}
