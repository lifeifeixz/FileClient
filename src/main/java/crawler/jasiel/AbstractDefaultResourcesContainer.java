package crawler.jasiel;

/**
 * @author flysLi
 * @date 2017/10/27
 */
@SuppressWarnings("All")
public class AbstractDefaultResourcesContainer implements Container {
    @Override
    public synchronized boolean addLink(String l) {
        return false;
    }

    @Override
    public synchronized boolean addVisible(String l) {
        return false;
    }

    @Override
    public synchronized boolean isNext() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
