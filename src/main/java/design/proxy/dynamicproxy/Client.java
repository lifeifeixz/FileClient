package design.proxy.dynamicproxy;

import design.proxy.staticproxy.Subject;

/**
 * 动态代理客户类
 *
 * @author flysLi
 * @date 2018/2/24
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = DynProxyFactory.getInstance();
        proxy.dealTask("DBQueryTask");
    }
}
