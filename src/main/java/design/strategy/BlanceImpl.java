package design.strategy;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class BlanceImpl implements PayStrategy {
    @Override
    public void pay(Double money) {
        System.out.println("银行卡支付了:" + money + "元");
    }
}
