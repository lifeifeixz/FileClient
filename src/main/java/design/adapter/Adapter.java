package design.adapter;

/**
 * Created by flysLi on 2017/10/20.
 * 实现适配器类
 */
public class Adapter implements IAdapter {
    @Override
    public String Drive() {
        return "变压器";
    }
}
