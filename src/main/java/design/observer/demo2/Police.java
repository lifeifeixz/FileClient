package design.observer.demo2;

/**
 * 警察
 *
 * @author flysLi
 * @date 2018/3/9
 */
public class Police implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，警察护航");
    }
}
