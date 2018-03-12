package design.dutychain;

/**
 * @author flysLi
 * @date 2018/3/9
 */
public class HrBoos extends LeaveHandler {
    @Override
    public void disposeLeave(int day) {
        if (day <= 5) {
            System.out.println("我是张总，我可以处理" + day + "天的假期");
        } else {
            //如果他处理不了就向上传递
            successor.disposeLeave(day);
        }
    }
}
