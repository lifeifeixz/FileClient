package mybatis;

import mybatis.demo.dao.UserDao;
import mybatis.demo.service.UserService;

/**
 *
 * @author flysLi
 * @date 2018/2/24
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        UserDao userDao = context.getBean(UserDao.class);
        userDao.insert("a", "b");
//        UserService userService = context.getBean(UserService.class);
//        userService.showUser();
    }
}
