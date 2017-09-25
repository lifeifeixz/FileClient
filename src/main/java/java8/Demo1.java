package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by flysLi on 2017/9/22.
 * 自定义排序
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("google");
        names.add("runoob");
        names.add("taobao");
        names.add("baidu");
        Collections.sort(names, (s1, s2) -> s2.compareTo(s1));

        for (String s : names){
            System.out.println(s);
        }
    }

    public static void se(Object o) {

    }
}
