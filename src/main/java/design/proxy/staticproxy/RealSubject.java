package design.proxy.staticproxy;

/**
 * @author flysLi
 * @date 2018/2/24
 * 委托角色，被代理者
 */
public class RealSubject implements Subject {

    /**
     * 打印出执行任务的名称
     *
     * @param taskName 任务名称
     */
    @Override
    public void dealTask(String taskName) {
        System.out.println("正在执行任务:" + taskName);
    }
}
