package design.command;

/**
 * 命令
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class MyCommand implements Command {

    /**
     * 命令需要一个具体的执行者
     **/
    private Receive receiver;

    public MyCommand(Receive receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    @Override
    public void exe() {
        /*
         * 命令的受理者开始干活
         */
        receiver.action();
    }
}
