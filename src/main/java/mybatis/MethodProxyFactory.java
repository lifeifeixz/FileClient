package mybatis;

import java.lang.reflect.Proxy;

/**
 * @author flysLi
 * @date 2018/2/24
 */
public class MethodProxyFactory {

    /**
     * 创建真实对象
     *
     * @param methodInterface
     * @param <T>
     * @return
     */
    public static <T> T newInstance(Class<T> methodInterface) {
        final MethodProxy<T> methodProxy = new MethodProxy(methodInterface);
        return (T) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{methodInterface},
                methodProxy);
    }
}
