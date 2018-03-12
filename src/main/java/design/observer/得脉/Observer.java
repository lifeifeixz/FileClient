package design.observer.得脉;

/**
 * 更新接口
 *
 * @author flysLi
 * @date 2018/3/9
 */
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
