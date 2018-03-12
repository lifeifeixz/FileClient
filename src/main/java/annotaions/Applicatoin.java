package annotaions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author flysLi
 * @date 2018/2/28
 */
public class Applicatoin {
    public static void main(String[] args) throws Exception {
//        Field[] fields = User.class.getDeclaredFields();
//        for (Field field : fields) {
//            Annotation[] annotations = field.getAnnotations();
//            System.out.println(field.getName() + "的注解");
//            for (Annotation annotation : annotations) {
//                System.out.println(annotation.toString());
//            }
//        }
//        System.out.println("类注解:");
//        System.out.println(User.class.getDeclaredAnnotations()[0].toString());

        Method[] methods = User.class.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println(uc.id());
                System.out.println(uc.description());
            }
        }
        /*lambds表达式*/
        List<String> list = new ArrayList<String>(100);
        list.forEach(System.out::println);
    }
}
