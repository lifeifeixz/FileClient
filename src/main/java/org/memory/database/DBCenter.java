package org.memory.database;

import java.util.*;

/**
 * Created by flysLi on 2017/9/2.
 * 单利
 */
public class DBCenter {
    public static DBCenter dbCenter;

    //行(字段)
    private List<String> cloumns = new ArrayList<>();

    //列(值)
    private Map<String, List<Object>> rows = new HashMap<>();

    private DBCenter() {

    }

    /**
     * 初始化对象
     *
     * @return
     */
    public static DBCenter instance() {
        if (dbCenter == null) {
            dbCenter = new DBCenter();
        }
        return dbCenter;
    }

    /**
     * 表结构只允许创建一次
     *
     * @param cloumns
     */
    public void createTable(String[] cloumns) {
        if (this.cloumns.size() > 0) {
            throw new RuntimeException("Columns can only be initialized once");
        }
        for (String cloumn : cloumns) {
            this.cloumns.add(cloumn);
        }
    }

    /**
     * 插入记录
     *
     * @param rows
     * @return
     */
    public List<Object> insert(String[] rows) {
        if (rows == null || rows.length == 0) {
            throw new RuntimeException("Inserting data cannot be null");
        } else if (rows.length != this.cloumns.size()) {
            throw new RuntimeException("All columns are not allowed to be empty");
        }
        List<Object> list = new ArrayList<>();
        for (String row : rows) {
            list.add(row);
        }
        return this.rows.put(UUID.randomUUID().toString(), list);
    }


    /**
     * 查询单条记录
     *
     * @param cloumn
     * @param val
     * @return
     */
    public List<Object> find(String cloumn, String val) {
        if (cloumn == null || cloumn.length() == 0) {
            throw new RuntimeException("Query fields are not null");
        }
        int cloumnLocal = this.cloumns.indexOf(cloumn);
        //遍历所有列，查看是否有符合条件的记录

        return null;
    }


}
