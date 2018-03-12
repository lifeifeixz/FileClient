package stick;

/**
 * Created by flysLi on 2018/1/9.
 */
public class Car implements Runnable {

    private String str;

    public Car(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        this.go();
    }

    public void go() {
        System.out.println(this.str + "已经开始跑了");
    }
}
