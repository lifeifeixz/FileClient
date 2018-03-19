package test.gongxaing.made;

import java.io.File;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public interface MadeStrategy {

    /**
     * 指定输出路径
     *
     * @param dom
     */
    void out(String dom);

    /**
     * 制作
     */
    void make(File file);

    void setMadeStrategy(MadeStrategy strategy);
}
