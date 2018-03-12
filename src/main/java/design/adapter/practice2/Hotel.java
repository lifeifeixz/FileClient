package design.adapter.practice2;

/**
 * @author flysLi
 * @date 2018/2/23
 */
public class Hotel {
    /**
     * 旅馆中有一个德标的插口
     **/
    private DBSocketInterface dbSocket;

    public Hotel() {

    }

    public Hotel(DBSocketInterface dbSocket) {
        this.dbSocket = dbSocket;
    }

    public void setSocket(DBSocketInterface dbSocket) {
        this.dbSocket = dbSocket;
    }

    /**
     * 充电功能
     */
    public void charge() {
        //使用德标插口充电
        dbSocket.powerWithTwoRound();
    }
}
