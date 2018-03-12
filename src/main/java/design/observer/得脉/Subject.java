package design.observer.得脉;

import java.util.Observer;

/**
 * 主题模块
 * 主题对象有3个基础操作：注册新的观察者、通知所有观察者更新数据、移除取消观察的观察者对象。
 *
 * @author flysLi
 * @date 2018/3/9
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
