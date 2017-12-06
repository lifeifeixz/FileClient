package streetlamp.org;

import streetlamp.org.entity.Page;

/**
 * @author flysLi
 * @date 2017/12/6
 */
public interface Machine {

    /**
     * 制作
     *
     * @param page
     * @return
     */
    String make(Page page);
}
