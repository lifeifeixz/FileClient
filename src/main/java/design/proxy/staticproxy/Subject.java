package design.proxy.staticproxy;

/**
 * @author flysLi
 * @date 2018/2/24
 */
public interface Subject {

    /**
     * 执行给定名称的任务
     *
     * @param taskName 任务名称
     */
    void dealTask(String taskName);
}
