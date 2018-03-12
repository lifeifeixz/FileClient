package mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 模拟通过动态代理产生instance
 *
 * @author flysLi
 * @date 2018/2/24
 */
public class MethodProxy<T> implements InvocationHandler {
    private Class<T> methodInterface;

    public MethodProxy(Class<T> methodInterface) {
        this.methodInterface = methodInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法的参数列表:");
        String str = "";
        for (Object o : args) {
            str += o;
            System.out.println(o);
        }
        System.out.println("返回类型:" + method.getReturnType());
        return str;
    }
}