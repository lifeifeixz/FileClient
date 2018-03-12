package reflect.chn;

/**
 * @author flysLi
 * @date 2018/2/22
 */
public class User {

    private String idNo;
    private String name;
    private String sex;
    private int age;

    public String getIdNo() {
        System.out.println("222");
        return idNo;
    }

    public void setIdNo(String idNo) {
        System.out.println("222");
        this.idNo = idNo;
    }

    public String getName() {
        System.out.println("222");
        return name;
    }

    public void setName(String name) {
        System.out.println("222");
        this.name = name;
    }

    public String getSex() {
        System.out.println("222");
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("222");
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "idNo:" + idNo + '\'' +
                ", name:" + name + '\'' +
                ", sex':" + sex + '\'' +
                ", age:" + age +
                '}';
    }
}
