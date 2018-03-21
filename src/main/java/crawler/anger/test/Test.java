package crawler.anger.test;

import crawler.anger.WormApplicationContext;
import crawler.anger.WormDepth;
import crawler.jasiel.Container;
import crawler.jasiel.ResourcesContainer;

/**
 *
 * @author flysLi
 * @date 2018/3/20
 */
public class Test {
    public static void main(String[] args) {
        WormApplicationContext applicationContext = new WormApplicationContext("crawler.anger");
        WormDepth wormDepth = applicationContext.getBean(WormDepth.class);
        Container container = ResourcesContainer.getInstance();
        container.addLink("http://www.sina.com.cn");
        wormDepth.grab();
    }
}
