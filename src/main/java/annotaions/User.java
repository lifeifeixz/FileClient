package annotaions;

/**
 * @author flysLi
 * @date 2018/2/28
 */

@Controller
public class User {
    @Generate("姓名")
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @UseCase(id = 47, description = "年龄必须输入,不可为空")
    public void setAge(int age) {
        this.age = age;
    }
}
