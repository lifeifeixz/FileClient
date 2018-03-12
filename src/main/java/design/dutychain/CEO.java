package design.dutychain;

/**
 * CEO具有最大权限
 *
 * @author flysLi
 * @date 2018/3/9
 */
public class CEO extends LeaveHandler {
    @Override
    public void disposeLeave(int day) {
        //因为这里所有的假期他都可以处理，所以没有判断
        System.out.println("我是CEO，我可以处理" + day + "天的假期");
    }
}
