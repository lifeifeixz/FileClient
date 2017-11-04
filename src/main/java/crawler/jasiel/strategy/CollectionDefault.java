package crawler.jasiel.strategy;

/**
 * Created by flysLi on 2017/11/4.
 */
public class CollectionDefault implements CollectionStrategy {
    @Override
    public boolean filter(String uri) {
        if (uri.indexOf("aqdyba.com/lusi") > -1) {
            return true;
        }
        return false;
    }
}
