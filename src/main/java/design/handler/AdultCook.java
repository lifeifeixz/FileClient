package design.handler;

import design.handler.enity.Adult;
import design.handler.enity.User;

/**
 * @author flysLi
 * @date 2017/11/2
 */
public class AdultCook extends CookHandler {
    @Override
    public void cook(User user) {
        if (user instanceof Adult) {
            System.out.println("成年人的中午饭已经做好");
        } else {
            this.getCookHandler().cook(user);
        }
    }
}
