package design.strategy;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class PayApplication {
    private String payType;

    public PayApplication() {

    }

    public PayApplication(String payType) {
        this.payType = payType;
    }

    public static void main(String[] args) {
        PayApplication application = new PayApplication("a");
        application.pay(23.66);
    }

    public void pay(Double money) {
        PayStrategy payStrategy;
        switch (this.payType) {
            case "WECHAT":
                payStrategy = new WechatImpl();
                break;
            case "ALIPAY":
                payStrategy = new AlipayImpl();
                break;
            default:
                payStrategy = new BlanceImpl();
                break;
        }
        payStrategy.pay(money);

    }
}
