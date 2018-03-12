package design.adapter.practice2;

/**
 * @author flysLi
 * @date 2018/2/23
 * @detail 适配器需要实现德标的功能
 */
public class SocketAdapter implements DBSocketInterface {
    private GBSocketInterface gbSocket;

    /**
     * 在创建适配器对象的时候，必须传入一个国产插头
     *
     * @param gbSocket
     */
    public SocketAdapter(GBSocketInterface gbSocket) {
        this.gbSocket = gbSocket;
    }

    /**
     * 德标插头充电
     */
    @Override
    public void powerWithTwoRound() {
        //使用国产插头充电
        this.gbSocket.powerWithThreeFlat();
    }
}
