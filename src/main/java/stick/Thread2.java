package stick;

/**
 * Created by flysLi on 2018/1/9.
 */
public class Thread2 {
    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {
            Car c7 = new Car("c" + i);
            Thread t7 = new Thread(c7);
            t7.start();
        }


    }
}
