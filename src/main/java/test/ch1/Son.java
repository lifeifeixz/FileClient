package test.ch1;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public class Son extends Father {

    String name = "李敢";

    @Override
    public void show() {
        super.showName();
    }
}
