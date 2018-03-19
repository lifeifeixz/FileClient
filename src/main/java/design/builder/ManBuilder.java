package design.builder;

/**
 * 实现Builder接口，针对不同的商业逻辑，
 * 具体化复杂对象的各部分的创建。
 * 在建造过程完成后，提供产品的实例
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class ManBuilder implements PersonBuilder {

    private Person person;

    public ManBuilder() {
        /*创建一个person实例，用于调用set方法*/
        this.person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("建造头部部分");
    }

    @Override
    public void buildBody() {
        person.setBody("建造身体部分");
    }

    @Override
    public void buildFoot() {
        person.setFoot("建造四肢部分");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
