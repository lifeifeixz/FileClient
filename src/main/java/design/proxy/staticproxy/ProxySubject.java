package design.proxy.staticproxy;

/**
 * @author flysLi
 * @date 2018/2/24
 * 代理类，实现了代理接口
 */
public class ProxySubject implements Subject {
    //代理类需要持有一个委托类的引用
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }

    @Override
    public void dealTask(String taskName) {
        long start = System.currentTimeMillis();
        this.delegate.dealTask(taskName);
        long end = System.currentTimeMillis();
        System.out.println("执行任务耗时:" + (end - start) + "毫秒");
    }
}
