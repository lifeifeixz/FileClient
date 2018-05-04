package test.ch1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author flysLi
 * @date 2018/4/19
 */
public class MapTest {
    public static void main(String[] args) {
        String key = "姓名2";
        Map<Object,Object> map = new HashMap(10);
        System.out.println(key.hashCode());
    }
}
