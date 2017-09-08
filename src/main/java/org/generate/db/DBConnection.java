package org.generate.db;

import org.generate.entity.Field;
import org.generate.entity.TableInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flysLi on 2017/8/30.
 */
@SuppressWarnings("all")
public class DBConnection {
    /**
     * 关闭数据库连接
     *
     * @param connection
     * @auther flys·Li
     */
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到数据库连接
     *
     * @return
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/javamg", "root", "123456");//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 查询所有字段
     *
     * @param sql
     * @param tableInfo
     * @return
     */
    public TableInfo findField(TableInfo tableInfo, String table) {
        String sql = "DESCRIBE " + table + ";";
        Connection connection = this.getConnection();
        ResultSet res = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            res = preparedStatement.executeQuery();//执行语句，得到结果集
            List<Field> fields = new ArrayList<>();
            while (res.next()) {
                Field field = new Field();
                field.setName(res.getString("Field").toLowerCase());
                field.setType(res.getString("Type"));
                fields.add(field);
            }
            tableInfo.setFieldList(fields);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
                connection.close();//关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tableInfo;
    }

    /**
     * 查询表组
     *
     * @param sql
     * @return
     */
    public List<TableInfo> fildTalbe(String databasename) {
        Connection connection = this.getConnection();
        ResultSet res = null;
        List<TableInfo> tableInfos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SHOW TABLES");
            res = preparedStatement.executeQuery();//执行语句，得到结果集
            ResultSetMetaData colums = res.getMetaData();//获取所有字段名

            while (res.next()) {
                TableInfo tableInfo = new TableInfo();
                tableInfo.setClassName(res.getString("Tables_in_" + databasename).toLowerCase());
                tableInfos.add(tableInfo);
                this.findField(tableInfo, res.getString("Tables_in_" + databasename));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
                connection.close();//关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tableInfos;
    }

    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());
    }
}
