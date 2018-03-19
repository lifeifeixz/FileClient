package test.ch1;

/**
 * Created by flysLi on 2017/10/19.
 */
public class Tflys implements User{

    public void eat() {
        System.out.println("小猪在吃饭");
    }

    public static void main(String[] args) {
        User user = new Tflys();
        user.eat();
    }
}
