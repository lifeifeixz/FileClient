package crawler.anger.test;

import crawler.anger.*;
import crawler.jasiel.Container;

/**
 * @author flysLi
 * @date 2018/3/30
 */
@SuppressWarnings("All")
public class BBSTYTest {
    public static void main(String[] args) {
        WormApplicationContext applicationContext = new WormApplicationContext("crawler.anger");
        Worm depth = applicationContext.getBean(WormDepth.class);
        Container container = applicationContext.getBean(ResourceWarehouse.class);
        container.addLink("http://www.redotsoft.com/");
        depth.grab();
    }
}
