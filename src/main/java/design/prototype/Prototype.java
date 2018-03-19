package design.prototype;

/**
 * 抽象原型角色
 *
 * @author flysLi
 * @date 2018/3/12
 */
public interface Prototype {

    /**
     * 克隆自身的方法
     *
     * @return 一个从自身克隆出来的对象
     */
    Prototype clone();
}
