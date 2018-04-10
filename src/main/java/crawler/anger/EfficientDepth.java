package crawler.anger;

/**
 * 高效率的Depth；
 * 该模块使用代理方式解决。
 * 默认10个线程
 *
 * @author flysLi
 * @date 2018/4/2
 */
@SuppressWarnings("All")
public class EfficientDepth implements Worm {
    private static int MAX = 10;
    /**
     * 创建一个可重用固定线程数的线程池
     **/
    Worm worm;

    @Override
    public void grab() {
    }
}
