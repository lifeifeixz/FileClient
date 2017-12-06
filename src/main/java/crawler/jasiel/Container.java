package crawler.jasiel;

import java.io.Serializable;

/**
 * 仓库接口
 *
 * @author flysLi
 * @date 2017/10/26
 */
public interface Container extends Serializable, Comparable {
    /**
     * 向仓库中添加一条新的数据
     *
     * @param l
     * @return
     */
    boolean addLink(String l);

    /**
     * 记录已经使用过的记录
     *
     * @param l
     * @return
     */
    boolean addVisible(String l);

    /**
     * 得到一条为访问过的记录
     *
     * @return
     */
    boolean isNext();

}
