package design.template.demo01;

/**
 * @author flysLi
 * @date 2018/2/26
 */
public class Application {
    public static void main(String[] args) {
        CarPurchaseTaxCalculationTemplate calculationTemplate = new ShangHaiPrice();
        calculationTemplate.finalPrice(160000.00);
    }
}
