package crawler.jasiel;

import java.io.Serializable;

/**
 * 仓库接口
 *
 * @author flysLi
 * @date 2017/10/26
 */
public interface Container extends Serializable, Comparable {
    boolean addLink(String l);

    boolean addVisible(String l);

    boolean isNext();

}
