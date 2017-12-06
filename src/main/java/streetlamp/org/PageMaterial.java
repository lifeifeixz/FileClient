package streetlamp.org;

import streetlamp.org.entity.Page;

/**
 * @author flysLi
 * @date 2017/12/6
 */
public interface PageMaterial {

    /**
     * 解析元素
     *
     * @param pageData
     * @return
     */
    Page analysisPage(String pageData);
}
