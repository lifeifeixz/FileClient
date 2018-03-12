package design.adapter.practice2;

/**
 * @author flysLi
 * @date 2018/2/23
 */
public class Application {
    public static void main(String[] args) {
        //初始化一个国标插头
        GBSocketInterface gbSocket = new GBSocket();

        //创建一个旅馆
        Hotel hotel = new Hotel();

        //创建一个适配器
        SocketAdapter adapter = new SocketAdapter(gbSocket);

        //将适配器插到德标插头上
        hotel.setSocket(adapter);

        //在旅馆中使用德标插座充电
        hotel.charge();
    }
}
