package crawler.jasiel;

import crawler.jasiel.strategy.StorageRedis;
import crawler.jasiel.strategy.StroragePrint;

/**
 * @author flysLi
 * @date 2017/10/31
 */
public class ApplicationImpl extends ApplicationTemplate {
    @Override
    protected void init() {
        this.urls = new String[1];
        System.out.println("初始化,暂时没有事情可做......");
    }

    @Override
    protected void initResource() {
        this.urls[0] = "https://y.qq.com/";
    }

    @Override
    protected boolean initStorageStrategy() {
        this.storageStrategy = new StroragePrint();
        return true;
    }
}
