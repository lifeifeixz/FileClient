package design.template;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class OracleJdbc extends JdbcTemplate {
    @Override
    public void initConnection() {
        System.out.println("oracle正在打开链接");
    }
}
