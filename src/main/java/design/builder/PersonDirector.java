package design.builder;

/**
 * 导演
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder personBuilder) {
        //按照 身体 --->头部--->四肢 的顺序创建人物
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildFoot();
        return personBuilder.buildPerson();
    }
}
