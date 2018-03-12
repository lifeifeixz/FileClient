package design.command;

/**
 * 命令的受理人(执行者)
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class Receiver implements Receive {
    @Override
    public void action() {
        System.out.println("command received!");
    }
}
