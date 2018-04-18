package test.ch1;

/**
 *
 * @author flysLi
 * @date 2018/4/13
 */
public class AbstractGoodTest {
    public static void main(String[] args) {
        AbstractGood a = new AbstractGood() {
            @Override
            public void show() {
                super.show();
            }

            @Override
            public void shows() {

            }
        };

        a.show();
    }
}
