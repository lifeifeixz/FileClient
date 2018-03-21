package crawler.anger;

/**
 * @author flysLi
 * @date 2018/3/20
 */
public interface Application {

    /**
     * 通过类型获取bean
     *
     * @param t
     * @param <T>
     * @return
     */
    <T> T getBean(Class<T> t);
}
