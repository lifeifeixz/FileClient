package org.heapbase.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flysLi on 2017/8/30.
 */
public class Test1 {

    public static void main(String[] args) {
        /**
         * 向list中塞入200万条string数据测试
         * return time
         */
        List<String> list = new ArrayList<String>();


        //第一个线程
        new Thread() {
            public void run() {
                Long start = System.currentTimeMillis();
                for (int i = 0; i < 5000000; i++) {
                    list.add("中文网" + i);
                }
                Long end = System.currentTimeMillis();
                System.out.println("线程1:" + (end - start) / 1000);
            }


        }.start();

        //第二个线程
        new Thread() {
            public void run() {
                Long start = System.currentTimeMillis();
                for (int i = 5000001; i < 10000000; i++) {
                    list.add("中文网" + i);
                }
                Long end = System.currentTimeMillis();
                System.out.println("线程2:" + (end - start) / 1000);
            }
        }.start();
    }
}
