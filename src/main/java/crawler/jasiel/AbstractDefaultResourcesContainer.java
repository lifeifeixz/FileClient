package crawler.jasiel;

/**
 * Created by flysLi on 2017/10/27.
 */
public class AbstractDefaultResourcesContainer implements Container{
    @Override
    public boolean addLink(String l) {
        return false;
    }

    @Override
    public boolean addVisible(String l) {
        return false;
    }

    @Override
    public boolean isNext() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
