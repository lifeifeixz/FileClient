package design.observer.得脉;

import java.util.ArrayList;

/**
 * 具体主题类实现(气象局)
 *
 * @author flysLi
 * @date 2018/3/9
 */
public class WeatherData implements Subject, Observer {
    private ArrayList observers = null;//关注者列表
    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压

    /**
     * 在构造气象台的时候初始化10个关注者位置
     */
    public WeatherData() {
        observers = new ArrayList(10);
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void registerObserver(java.util.Observer o) {

    }

    @Override
    public void removeObserver(java.util.Observer o) {
        int i = observers.indexOf(o);
        if (i > 0) {
            observers.remove(i);
        }
    }

    /**
     * 更新通知所有的观察者
     */
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Statistics: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
