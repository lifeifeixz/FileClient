package bdata.hive;

import java.sql.*;

/**
 * @author flysLi
 * @date 2018/2/7
 */
public class TestHive {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * 获取连接
     */
    public void getConnection() {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            try {
                connection = DriverManager.getConnection("jdbc:hive2://192.168.202.137:10000/test", "root", "");
                System.out.println(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestHive testHive = new TestHive();
        testHive.getConnection();
    }
}
