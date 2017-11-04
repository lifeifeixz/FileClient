package design.handler;

import design.handler.enity.Children;
import design.handler.enity.User;

/**
 *
 * @author flysLi
 * @date 2017/11/2
 */
public class ChildrenCook extends CookHandler {
    @Override
    public void cook(User user) {
        if (user instanceof Children) {
            System.out.println("儿童餐已经做好");
        } else {
            this.getCookHandler().cook(user);
        }
    }
}
