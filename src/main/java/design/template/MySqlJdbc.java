package design.template;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class MySqlJdbc extends JdbcTemplate {
    @Override
    public void initConnection() {
        System.out.println("mysql正在打开链接");
    }
}
