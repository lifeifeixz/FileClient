package design.strategy;

/**
 * Created by flysLi on 2018/2/22.
 */
public class WechatImpl implements PayStrategy {
    @Override
    public void pay(Double money) {
        System.out.println("微信支付了:" + money + "元");
    }
}
