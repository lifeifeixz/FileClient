package design.handler;

import design.handler.enity.User;

/**
 * 接盘侠
 *
 * @author admin
 * @date 2017/11/2
 */
public class AllCook extends CookHandler {
    @Override
    public void cook(User user) {
        System.out.println("找不到合适的就餐区域，就只能到我这里了。");
    }
}
