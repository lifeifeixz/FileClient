package test.xingneng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flysLi on 2017/12/13.
 */
public class InsertData {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        System.out.println("开始时间:" + start);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            list.add("1241as");
        }
        Long end = System.currentTimeMillis();
        System.out.println("结束时间:" + end);
        System.out.println("结果:" + ((Double.valueOf(end) - Double.valueOf(start)) / 1000));
        System.out.println(list.size());
    }
}
