package crawler.jasiel;

import crawler.jasiel.strategy.AnalysisStrategy;
import crawler.jasiel.strategy.StorageStrategy;

/**
 * Created by flysLi on 2017/10/31.
 */
@SuppressWarnings("all")
public abstract class ApplicationTemplate {
    protected String[] urls;
    protected StorageStrategy storageStrategy;
    protected AnalysisStrategy analysisStrategy;

    protected abstract void init();

    protected abstract void initResource();

    protected abstract boolean initStorageStrategy();

    /**
     * 开始收集
     */
    private int start() {
        for (String uri : urls) {
            new Thread(() -> {
                JasieLusion jasieLusion = new JasieLusion();
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
