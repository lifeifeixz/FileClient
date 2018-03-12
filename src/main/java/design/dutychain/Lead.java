package design.dutychain;

/**
 * 项目经理可以批准一天的假期
 *
 * @author flysLi
 * @date 2018/3/9
 */
public class Lead extends LeaveHandler {

    @Override
    public void disposeLeave(int day) {
        if (day <= 1) {
            System.out.println("我是胡经理，我可以处理" + day + "天的假期");
        } else {
            //如果他处理不了就想向上传递
            successor.disposeLeave(day);
        }
    }
}
