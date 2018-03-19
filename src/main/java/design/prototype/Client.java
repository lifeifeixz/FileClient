package design.prototype;

/**
 * @author flysLi
 * @date 2018/3/12
 */
public class Client {
    /**
     * 持有需要使用的原型接口对象
     **/
    private Prototype prototype;

    /**
     * 构造方法，传入需要使用的原型接口对象
     *
     * @param prototype
     */
    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    /**
     * 创建原型接口对象
     *
     * @param example
     */
    public void operation(Prototype example) {
        Prototype copyPrototype = prototype.clone();
    }

}
