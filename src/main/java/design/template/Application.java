package design.template;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class Application {
    public static void main(String[] args) {
        //mysql
        JdbcTemplate jdbcTemplate = new MySqlJdbc();
        jdbcTemplate.operation();

        //oracle
        jdbcTemplate = new OracleJdbc();
        jdbcTemplate.operation();
    }
}
