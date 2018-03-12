package design.template;

/**
 * 操作数据库的步骤分为4步：
 * 1.打开链接
 * 2.操作(增删改查)
 * 3.关闭连接
 * 对于第一步，每个数据库都有不同的连接方式
 *
 * @author flysLi
 * @date 2018/2/22
 */
public abstract class JdbcTemplate {

    /**
     * 每个数据库的链接方式不同
     * 这里需要子类去特殊实现
     */
    public abstract void initConnection();

    public final void operation() {
        this.initConnection();
        System.out.println("开始操作，，，增删改查");
        this.closeConnection();
    }

    public final void closeConnection() {
        System.out.println("关闭连接");
    }
}
