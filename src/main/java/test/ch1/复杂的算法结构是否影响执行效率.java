package test.ch1;

/**
 * 该程序用于验证复杂的逻辑是否会延长程序的执行时间
 *
 * @author flysLi
 * @date 2018/3/22
 */
public class 复杂的算法结构是否影响执行效率 {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int j = 0;
        for (int i = 0; i < 100000; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                j++;
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
