package design.adapter;

/**
 * Created by flysLi on 2017/10/20.
 * <strong>实现对象适配器</strong>
 * //定义输出电压为220V的变压器类
 */
public class CObject implements IAdapter {
    private ChangeAdapter changeAdapter;

    public CObject() {
        changeAdapter = new ChangeAdapter();
    }

    @Override
    public String Drive() {
        return changeAdapter.Web("（2）输出电压：220V");
    }
}
