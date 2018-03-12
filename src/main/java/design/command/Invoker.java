package design.command;

/**
 * 调用者、即命令的发布者
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class Invoker {
    /**
     * 持有命令引用
     **/
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 发出命令,并得到结果
     */
    public void action() {
        /*发出命令*/
        command.exe();
    }
}
