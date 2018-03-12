package design.adapter.practice2;

/**
 * @author flysLi
 * @date 2018/2/23
 */
public class DBSocket implements DBSocketInterface {
    @Override
    public void powerWithTwoRound() {
        System.out.println("使用两项圆头的插孔供电");
    }
}
