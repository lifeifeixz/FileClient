package design.observer.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的被观察者(黄金运输车)
 *
 * @author flysLi
 * @date 2018/3/9
 */
public class Transporter implements Watched {

    private List<Watcher> list = new ArrayList<Watcher>(10);

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers() {
        for (Watcher watcher : list) {
            watcher.update();
        }
    }
}
