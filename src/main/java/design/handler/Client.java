package design.handler;

import design.handler.enity.Children;
import design.handler.enity.Student;

/**
 * @author flysLi
 * @date 2017/11/2
 */
public class Client {
    public static void main(String[] args) {
        CookHandler childrenCook = new ChildrenCook();
        CookHandler adultCook = new AdultCook();
        CookHandler allCook = new AllCook();

        childrenCook.setCookHandler(adultCook);
        adultCook.setCookHandler(allCook);

        childrenCook.cook(new Student());
        childrenCook.cook(new Children());
    }
}
