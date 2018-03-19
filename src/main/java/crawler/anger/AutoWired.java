package crawler.anger;

import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by flysLi on 2018/3/19.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Document
public @interface AutoWired {
}
