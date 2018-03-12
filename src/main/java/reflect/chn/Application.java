package reflect.chn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class Application {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Field[] fields = User.class.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }

        User user = new User();
        Method setNameMethod = user.getClass().getMethod("setName", String.class);
        setNameMethod.invoke(user, "李菲菲");
        System.out.println(user.toString());
    }
}
