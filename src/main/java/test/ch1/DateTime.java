package test.ch1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by flysLi on 2017/11/17.
 */
public class DateTime {
    public static void main(String[] args) {
        String str = "1509958800000";
        Long time = Long.parseLong(str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date(time);
        System.out.println(sdf.format(date));
    }
}
