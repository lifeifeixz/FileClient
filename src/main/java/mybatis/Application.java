package mybatis;

import mybatis.demo.dao.UserDao;

/**
 * @author flysLi
 * @date 2018/2/24
 */
public class Application {
    public static void main(String[] args) {
        UserDao userDao = MethodProxyFactory.newInstance(UserDao.class);
        System.out.println(userDao.insert("a", "1"));
    }
}
