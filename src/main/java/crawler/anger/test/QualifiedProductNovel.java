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
        
        return true;
    }
}
