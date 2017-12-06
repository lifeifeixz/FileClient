package streetlamp.org.entity;

import java.util.List;

/**
 * @author flysLi
 * @date 2017/12/6
 */
public class Page {
    private List<Field> fieldList;
    private List<Input> inputs;

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }
}
