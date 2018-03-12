package design.dutychain;

/**
 * 职责链：抽象处理者
 *
 * @author flysLi
 * @date 2018/3/9
 */
public abstract class LeaveHandler {

    /**
     * 后继处理者
     */
    protected LeaveHandler successor;

    public void setSuccessor(LeaveHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理请假申请
     *
     * @param day 假期天数
     */
    public abstract void disposeLeave(int day);

}
