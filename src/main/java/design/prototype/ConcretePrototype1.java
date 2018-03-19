package design.prototype;

/**
 * @author flysLi
 * @date 2018/3/12
 */
public class ConcretePrototype1 implements Prototype {
    /**
     * 最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
     *
     * @return
     */
    @Override
    public Prototype clone() {
        return new ConcretePrototype1();
    }
}
