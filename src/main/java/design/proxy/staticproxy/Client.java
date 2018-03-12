package design.proxy.staticproxy;

/**
 * @author flysLi
 * @date 2018/2/24
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = SubjectStaticFactory.getInstance();
        proxy.dealTask("射击游戏");

    }
}
