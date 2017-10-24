package design.adapter;

/**
 * Created by flysLi on 2017/10/20.
 */
public class Application {
    public static void main(String[] args) {
        IAdapter iAdapter = new Adapter();
        System.out.println(iAdapter.Drive());
        iAdapter = new CClass();
        //调用第一个适配器
        System.out.println(iAdapter.Drive());
        iAdapter = new CObject();
        //调用第二个适配器
        System.out.println(iAdapter.Drive());
    }
}
