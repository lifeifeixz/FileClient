package test;

import org.springframework.remoting.RemoteTimeoutException;

/**
 * @author flysLi
 * @date 2018/1/30
 */
public class Exceptions {
    public static void main(String[] args) {

        try {
            System.out.println("第一次");
            excute();
        } catch (Exception e) {
            try {
                System.out.println("第二次");
                excute();
            } catch (Exception e1) {
                try {
                    System.out.println("第三次");
                    excute();
                } catch (Exception e2) {
                    throw new RemoteTimeoutException("不给执行了");
                }
            }
        }
    }

    public static void excute() throws Exception {
        String str = null;
        str.length();
    }
}
