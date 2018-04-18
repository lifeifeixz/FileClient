package test.ch1;

import java.io.File;
import java.io.IOException;

/**
 * @author flysLi
 * @date 2018/4/18
 */
public class OpenFile {
    public static void main(String[] args) {
        File file = new File("D:\\workspace_student\\FileClient\\src\\main\\java\\test\\gongxaing\\sources\\rawmaterial\\调度派单操作记录-table");
        Runtime ce = Runtime.getRuntime();
        System.out.println(file.getAbsolutePath());
        try {
            ce.exec("cmd   /c   start  " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
