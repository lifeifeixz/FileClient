package org.generate;

public class Emp {

    private String ename;

    public String getEname() {
        return ename;
    }

    public void setEname(String s) {
        ename = s;
    }

    public Emp() {
        ename = "yy";
    }

    public void printInfo() {
        System.out.println("begin!");
        System.out.println(ename);
        System.out.println("over!");
    }
}
