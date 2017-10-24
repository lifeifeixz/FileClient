package design.templatemethod;

/**
 * Created by flysLi on 2017/10/20.
 */
@SuppressWarnings("all")
public abstract class AbstractPerson {
    //抽象定义整个流程骨架
    public void perpareGotoSchool() {
        dressUp();
        eatBreakfast();
        takeThings();
    }

    //以下是不同子类根据自身特性完成的具体步骤
    protected abstract void dressUp();

    protected abstract void eatBreakfast();

    protected abstract void takeThings();
}
