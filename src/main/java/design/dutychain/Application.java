package design.dutychain;

/**
 * @author flysLi
 * @date 2018/3/9
 */
public class Application {
    public static void main(String[] args) {
        LeaveHandler lea = LeaveHandlerFactory.createHandler();
        lea.disposeLeave(1);
    }
}
