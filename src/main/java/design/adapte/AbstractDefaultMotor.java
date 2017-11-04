package design.adapte;

/**
 * @author flysLi
 * @date 2017/11/3
 */
public abstract class AbstractDefaultMotor implements Motor {
    @Override
    public abstract void turn(int sum);

    @Override
    public boolean charge(Long ma) {
        return false;
    }

    @Override
    public void eat() {

    }
}
