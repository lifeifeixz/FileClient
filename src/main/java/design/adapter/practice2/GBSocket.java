package design.adapter.practice2;

/**
 * @author flysLi
 * @date 2018/2/23
 * 国产插头
 */
public class GBSocket implements GBSocketInterface {
    @Override
    public void powerWithThreeFlat() {
        System.out.println("使用三相插头充电");
    }
}
