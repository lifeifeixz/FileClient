package crawler.jasiel;

import crawler.RedisConfig;
import crawler.jasiel.strategy.StorageRedis;

/**
 * @author flysLi
 * @date 2017/10/31
 */
public class ApplicationImpl extends ApplicationTemplate {
    @Override
    protected void init() {
//        RedisConfig redisConfig = new RedisConfig();
//        redisConfig.setHost("localhost");
//        redisConfig.setPort(6379);
        this.urls = new String[1];
        System.out.println("初始化,暂时没有事情可做......");
    }

    @Override
    protected void initResource() {
        this.urls[0] = "http://shanghai.bitauto.com/";
    }

    @Override
    protected boolean initStorageStrategy() {
        this.storageStrategy = new StorageRedis();
        return true;
    }
}
