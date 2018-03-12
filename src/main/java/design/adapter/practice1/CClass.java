package design.adapter.practice1;

/**
 * Created by flysLi on 2017/10/20.
 * @author flysLi
 */
public class CClass extends ChangeAdapter implements IAdapter{
    @Override
    public String Drive() {
        return this.Web("(1)输出电压:110V");
    }
}
