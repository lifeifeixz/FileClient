package test.gongxiang2.model;

/**
 * 页面模块所需要的数据的容器
 *
 * @author flysLi
 * @date 2018/3/29
 */
public class Modular {

    /**
     * 查询字段
     **/
    private Fields tds;

    /**
     * 表格显示字段
     **/
    private Querys querys;

    /**
     * 模块类型：报表、表单...
     **/
    private String modularType;

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
