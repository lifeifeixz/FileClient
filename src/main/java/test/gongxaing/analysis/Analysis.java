package test.gongxaing.analysis;

import test.gongxaing.Field;

import java.io.File;
import java.util.List;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public interface Analysis {

    /**
     * 解析出字段
     *
     * @return
     */
    List<Field> analysis(File file);
}
