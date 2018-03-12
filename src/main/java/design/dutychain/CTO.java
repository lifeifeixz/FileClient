package design.dutychain;

/**
 * 技术总监可以批准三天的假期
 *
 * @author flysLi
 * @date 2018/3/9
 */
public class CTO extends LeaveHandler {
    @Override
    public void disposeLeave(int day) {
        if (day <= 3) {
            System.out.println("我叫做王总监，我可以处理" + day + "内的假期");
        } else {
            // 如果他处理不了就向上传递请求
            successor.disposeLeave(day);
        }

    }

}