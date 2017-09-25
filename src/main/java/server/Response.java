package server;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public interface Response {

    /**
     * 发送结果
     *
     * @param result
     */
    void send(byte[] data);
}
