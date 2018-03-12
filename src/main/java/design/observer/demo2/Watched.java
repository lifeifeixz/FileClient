package design.observer.demo2;

/**
 * 抽象的被观察者,在其中声明方法（添加、移除观察者，通知观察者）：
 *
 * @author flysLi
 * @date 2018/3/9
 */
public interface Watched {
    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatchers();
}
