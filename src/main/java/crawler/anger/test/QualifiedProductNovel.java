package crawler.anger.test;

import crawler.anger.Compont;
import crawler.anger.QualifiedProduct;

/**
 * @author flysLi
 * @date 2018/3/20
 */
@Compont
public class QualifiedProductNovel implements QualifiedProduct {
    @Override
    public boolean verification(String url) {
        if (url != null && url.trim().length() > 4 && url.indexOf("http") > -1) {
            return true;
        }
        return false;
    }
}
