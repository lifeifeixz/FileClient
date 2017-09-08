package org.generate.entity;

/**
 * Created by flysLi on 2017/8/30.
 */
public class Field {
    private String name;

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //去除下划线，首字母大写
        String[] ps = name.split("_");
        if (ps.length > 1) {
            name = "";
            for (int i = 0; i < ps.length; i++) {
                if (i > 0) {
                    name += ps[i].substring(0, 1).toUpperCase() + ps[i].substring(1);
                } else {
                    name += ps[i];
                }
            }
        }
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
