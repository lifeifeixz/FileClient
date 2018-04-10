package test.gongxaing.model;

/**
 * 页面模块所需要的数据的容器
 *
 * @author flysLi
 * @date 2018/3/29
 */
public class Modular {

    /**
     * 列表显示字段
     **/
    private Fields tds;
    private Querys querys;

    public Fields getTds() {
        return tds;
    }

    public void setTds(Fields tds) {
        this.tds = tds;
    }

    public Querys getQuerys() {
        return querys;
    }

    public void setQuerys(Querys querys) {
        this.querys = querys;
    }
}
