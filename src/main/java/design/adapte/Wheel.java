package design.adapte;

/**
 * Created by flysLi on 2017/11/3.
 */
public class Wheel extends AbstractDefaultMotor {
    @Override
    public void turn(int sum) {
        System.out.println("汽车的轮子转起来了");
    }
}
