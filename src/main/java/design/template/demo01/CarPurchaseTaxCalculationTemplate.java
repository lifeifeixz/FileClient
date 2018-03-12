package design.template.demo01;

/**
 * 计算流程：
 * 1.购置税为产品总价的10%；
 * 2.地方税务局会有相应优惠(部分地区会根据税价的高低来进行调整优惠幅度)
 * 3.
 *
 * @author flysLi
 * @date 2018/2/26
 */
public abstract class CarPurchaseTaxCalculationTemplate {

    /**
     * 车辆总价乘以10%为购置税的价格
     *
     * @param vehiclePrice
     * @return Double
     */
    private final Double culationTaxCal(Double vehiclePrice) {
        return vehiclePrice * 0.1;
    }

    public abstract Double culationRegion(Double purchaseTaxPrice);

    public final void finalPrice(Double vehiclePrice) {
        System.out.println("最终购置税金额为:" + this.culationRegion(this.culationTaxCal(vehiclePrice)));
    }
}
