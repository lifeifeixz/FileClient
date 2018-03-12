package design.observer.demo2;

/**
 * @author flysLi
 * @date 2018/3/9
 */
public class Application {
    public static void main(String[] args) {
        Watched transporter = new Transporter();

        Police police = new Police();
        Security security = new Security();
        Thief thief = new Thief();

        transporter.addWatcher(police);
        transporter.addWatcher(security);
        transporter.addWatcher(thief);

        //观察
        transporter.notifyWatchers();

        //删除订阅者保安
        transporter.removeWatcher(security);

        //再观察
        transporter.notifyWatchers();
    }
}
