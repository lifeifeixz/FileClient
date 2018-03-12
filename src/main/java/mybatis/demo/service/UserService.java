package mybatis.demo.service;

import mybatis.demo.dao.UserDao;

/**
 * @author flysLi
 * @date 2018/2/24
 */
public class UserService {
    private UserDao userDao;

    public void showUser() {
        /**
         * 在代理中输出传入的参数
         */
        System.out.println(userDao.insert("名字", "ID"));
    }
}
