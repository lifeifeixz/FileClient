package design.proxy.dynamicproxy;

import design.proxy.staticproxy.RealSubject;
import design.proxy.staticproxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 生成动态代理对象的工厂
 *
 * @author flysLi
 * @date 2018/2/24
 */
public class DynProxyFactory {

    /**
     * 客户端调用此工厂方法获得代理对象。
     * 对客户类来说，其并不知道返回的是代理类还是委托类的对象
     *
     * @return Subject
     */
    public static Subject getInstance() {
        Subject delegate = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandle(delegate);
        Subject proxy;
        proxy = (Subject) Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                handler);
        return proxy;
    }
}
