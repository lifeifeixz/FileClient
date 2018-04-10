package test.gongxaing.made;

import java.io.File;

/**
 * @author flysLi
 * @date 2018/3/16
 */
public class MadeDefault extends AbstractMadeDefault {
    @Override
    public String make(File file) {
        return "暂时无人帮您处理该业务";
    }

    @Override
    public void setMadeStrategy(MadeStrategy strategy) {
        this.madeStrategy = strategy;
    }
}
