package design.observer.demo2;

/**
 * 强盗
 * @author flysLi
 * @date 2018/3/9
 */
public class Thief implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，强盗准备动手");
    }
}
