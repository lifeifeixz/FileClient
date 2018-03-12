package mybatis.demo.dao;

/**
 *
 * @author flysLi
 * @date 2018/2/24
 */
public interface UserDao {

    /**
     * 新增一条记录
     *
     * @param id
     * @param name
     */
    String insert(String id, String name);
}
