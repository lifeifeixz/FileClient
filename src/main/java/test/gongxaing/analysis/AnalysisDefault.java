package test.gongxaing.analysis;

import test.gongxaing.Field;

import java.io.File;
import java.util.List;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public class AnalysisDefault extends AbstractAnalysisDefault {
    @Override
    public List<Field> analysis(File file) {
        return null;
    }

    @Override
    public List<Field> analysisLine(File file) {
        return null;
    }

    @Override
    public boolean isContain(String path) {
        int index = path.indexOf(type);
        return index > 0 ? true : false;
    }
}
