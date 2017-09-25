package test;

/**
 * Created by flysLi on 2017/9/20.
 * <p>
 * 方法多参数设置
 */
public class Aregements {

    public void insert(Object... objects) {
        System.out.println(objects[0]);
        System.out.println(objects[1]);
        System.out.println(objects.length);
    }

    public static <T> T instance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        Aregements aregements = new Aregements();
//        aregements.insert(new Date(), 5);
        Test1 t1 = Aregements.instance(Test1.class);
        System.out.println(t1.toString());
    }
}
