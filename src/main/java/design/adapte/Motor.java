package design.adapte;

/**
 * Created by flysLi on 2017/11/3.
 */
public interface Motor {
    void turn(int sum);
    boolean charge(Long ma);
    void eat();
}
