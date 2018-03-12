package annotaions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by flysLi on 2018/2/28.
 *
 * @author flysLi
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Generate {
    String value();
}
