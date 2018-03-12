package design.dutychain;

/**
 * @author flysLi
 * @date 2018/3/9
 */
public class LeaveHandlerFactory {

    public static LeaveHandler createHandler() {
        LeaveHandler lead = new Lead();
        LeaveHandler cto = new CTO();
        LeaveHandler hrBoos = new HrBoos();
        LeaveHandler ceo = new CEO();
        lead.setSuccessor(cto);
        cto.setSuccessor(hrBoos);
        hrBoos.setSuccessor(ceo);
        return lead;
    }
}
