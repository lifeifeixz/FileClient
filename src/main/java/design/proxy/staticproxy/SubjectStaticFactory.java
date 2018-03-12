package design.proxy.staticproxy;

/**
 * @author flysLi
 * @date 2018/2/24
 */
public class SubjectStaticFactory {
    public static Subject getInstance() {
        return new ProxySubject(new RealSubject());
    }
}
