package org.generate.entity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flysLi on 2017/8/30.
 */
@SuppressWarnings("all")
public class TableInfo {
    private String packageName;

    private String className;

    private List<Field> fieldList;

    private List<Method> methods;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String toString() {
        return "TableInfo{" +
                "packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                ", fieldList=" + fieldList +
                ", methods=" + methods +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        //去除下划线，首字母大写
        String[] ps = className.split("_");
        if (ps.length > 1) {
            className = "";
            for (int i = 0; i < ps.length; i++) {
                className += ps[i].substring(0, 1).toUpperCase() + ps[i].substring(1);
            }
        }
        this.className = className;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public static void main(String[] args) {
        TableInfo tableInfo = new TableInfo();
        Field field = new Field();
        field.setName("dat_name_sad");
        List<Field> fields = new ArrayList<Field>();
        fields.add(field);
        tableInfo.setFieldList(fields);
        System.out.println(tableInfo.toString());
    }

}
