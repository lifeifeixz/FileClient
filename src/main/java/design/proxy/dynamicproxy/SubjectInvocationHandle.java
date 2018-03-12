package design.proxy.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类对应的调用处理程序类
 *
 * @author flysLi
 * @date 2018/2/24
 */
public class SubjectInvocationHandle implements InvocationHandler {

    /**
     * 代理类持有一个委托类的对象引用
     **/
    private Object delegate;

    public SubjectInvocationHandle(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long stime = System.currentTimeMillis();
        //利用反射机制将请求分派给委托处理类。Method的invoke返回Object对象作为方法执行结果
        //因为示例程序没有返回值，所以这里忽略了返回值处理
        method.invoke(delegate, args);
        long ftime = System.currentTimeMillis();
        System.out.println("执行任务耗时" + (ftime - stime) + "毫秒");
        return null;
    }
}
