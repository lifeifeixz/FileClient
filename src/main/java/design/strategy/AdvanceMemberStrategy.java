package design.strategy;

/**
 * 高级会员折扣类
 */
@SuppressWarnings("all")
public class AdvanceMemberStrategy implements MemberStrategy {
    public double calcPrice(double booksPrice) {
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
