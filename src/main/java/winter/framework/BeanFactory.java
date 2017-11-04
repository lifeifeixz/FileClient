package winter.framework;

/**
 * @author flysLi
 * @date 2017/11/3
 */
@SuppressWarnings("all")
public interface BeanFactory {

    /**
     * 获取Object的bean，需要强制转换
     *
     * @param className
     * @return
     */
    Object getBean(String className);

    /**
     * 获取任意类型的bean
     *
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T getBean(Class<T> tClass);

    boolean isSingle();
}
