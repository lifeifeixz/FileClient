package crawler.anger;

import crawler.jasiel.Container;

/**
 * 更加先进的，或者使用起来更简单的。
 *
 * @author flysLi
 * @date 2018/3/20
 */
public class AdvancedApplicationContext extends WormApplicationContext {
    /**
     * 搜寻方式
     * depth：深度搜寻
     * plane：平面搜寻
     **/
    public static final String DISMENSION = "depth";

    public AdvancedApplicationContext(String packing) {
        super(packing);
    }

    public static void main(String[] args) {
        Application application = new AdvancedApplicationContext("crawler.anger");
        Worm depth = application.getBean(WormDepth.class);
        Container container = application.getBean(ResourceWarehouse.class);
        container.addLink("http://www.jingyu.com");
        depth.grab();
        System.out.println("ok");
    }


}
