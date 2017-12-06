package streetlamp.org.entity;

/**
 * @author flysLi
 * @date 2017/12/6
 */
public class Field {
    private String name;
    private FieldType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }
}
