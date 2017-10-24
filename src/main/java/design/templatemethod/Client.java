package design.templatemethod;

/**
 * Created by flysLi on 2017/10/20.
 */
public class Client {
    public static void main(String[] args) {
        Student student = new Student();
        student.perpareGotoSchool();

        Teacher teacher = new Teacher();
        teacher.perpareGotoSchool();
    }
}
