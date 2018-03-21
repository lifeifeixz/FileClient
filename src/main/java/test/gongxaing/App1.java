package test.gongxaing;

import test.gongxaing.made.MadeStrategy;

import java.io.*;

/**
 * @author flysLi
 * @date 2018/3/12
 */
public class App1 {
    public static void main(String[] args) throws Exception {
        GenerateConfig.generateConfig.setFile(new File("D:\\workspace_student\\FileClient\\src\\main\\java\\test\\gongxaing\\sources\\rawmaterial\\daishenhe-table"));
        File file = new File(GenerateConfig.generateConfig.getFile().getPath());
        /*made*/
        MadeStrategy madeStrategy = BeanFactory.getMadeStrategyInstance();
        madeStrategy.make(file);
        System.out.println("制作完成");
    }
}
