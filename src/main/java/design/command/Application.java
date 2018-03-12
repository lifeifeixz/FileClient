package design.command;

/**
 * @author flysLi
 * @date 2018/3/12
 */
public class Application {
    public static void main(String[] args) {
        Receive receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
