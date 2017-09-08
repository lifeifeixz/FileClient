package org.generate.test;

import org.generate.db.DBConnection;
import org.generate.entity.TableInfo;
import org.generate.made.GenerageNewClass;

import java.util.List;

/**
 * Created by flysLi on 2017/8/30.
 */
public class Application {
    public static void main(String[] args) {

        DBConnection dbConnection = new DBConnection();
        List<TableInfo> tableInfos = dbConnection.fildTalbe("javamg");
        for (TableInfo tableInfo : tableInfos) {
            tableInfo.setPackageName("com.model");
            GenerageNewClass generageNewClass = new GenerageNewClass(tableInfo);
            generageNewClass.makeJava();
        }
        System.out.println("------------");
    }
}
