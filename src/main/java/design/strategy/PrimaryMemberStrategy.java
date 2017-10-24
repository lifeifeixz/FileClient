package design.strategy;

/**
 * 初级会员折扣类
 */
@SuppressWarnings("all")
public class PrimaryMemberStrategy implements MemberStrategy {
    public double calcPrice(double booksPrice) {
        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }
}
