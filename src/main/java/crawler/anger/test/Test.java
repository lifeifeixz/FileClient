package crawler.anger.test;

import crawler.anger.ResourceWarehouse;
import crawler.anger.WormApplicationContext;
import crawler.anger.WormDepth;
import crawler.jasiel.Container;
import crawler.jasiel.ResourcesContainer;

/**
 * @author flysLi
 * @date 2018/3/20
 */
@SuppressWarnings("All")
public class Test {
    public static void main(String[] args) {
        WormApplicationContext applicationContext = new WormApplicationContext("crawler.anger");
        WormDepth wormDepth = applicationContext.getBean(WormDepth.class);
        Container container = applicationContext.getBean(ResourceWarehouse.class);
        container.addLink("http://www.sina.com.cn");
        wormDepth.grab();
    }
}
