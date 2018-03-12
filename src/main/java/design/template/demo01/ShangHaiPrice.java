package design.template.demo01;

/**
 * @author flysLi
 * @date 2018/2/26
 */
public class ShangHaiPrice extends CarPurchaseTaxCalculationTemplate {
    private final static Double MONEY = 16000.00;

    @Override
    public Double culationRegion(Double purchaseTaxPrice) {

        /**
         * 上海地区如果购置税的价格超过了16000元的话，将打九折；
         */
        if (purchaseTaxPrice >= ShangHaiPrice.MONEY) {
            return purchaseTaxPrice - (purchaseTaxPrice * 0.1);
        }
        return purchaseTaxPrice;
    }
}
