package crawler.jasiel;

import crawler.jasiel.strategy.StorageRedis;
import crawler.jasiel.strategy.StorageStrategy;
import crawler.jasiel.strategy.StroragePrint;

/**
 * Created by flysLi on 2017/10/31.
 */
@SuppressWarnings("all")
public abstract class ApplicationTemplate {
    protected String[] urls;

    protected StorageStrategy storageStrategy;

    protected abstract void init();

    protected abstract void initResource();

    protected abstract boolean initStorageStrategy();

    /**
     * 开始收集
     */
    private int start() {
        for (String uri : urls) {
            new Thread(() -> {
                JasieLusion jasieLusion = new JasieLusion(uri);
                jasieLusion.setStorageStrategy(storageStrategy);
                jasieLusion.start();
            }).start();
        }
        return urls.length;
    }

    public int run() {
        this.init();
        this.initResource();
        this.initStorageStrategy();
        return this.start();
    }
}
