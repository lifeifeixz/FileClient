package design.adapter.practice1;

/**
 *
 * @author flysLi
 * @date 2017/10/20
 * 实现适配器类
 */
public class Adapter implements IAdapter {
    @Override
    public String Drive() {
        return "变压器";
    }
}
