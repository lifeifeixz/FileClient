package test.recogn;

import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;

/**
 * @author flysLi
 * @date 2018/5/3
 */
public abstract class AbstractOcr implements Ocr {
    public static final String APP_ID = "11188041";
    public static final String API_KEY = "CrvaqBAOZIopM8nas4bAamxG";
    public static final String SECRET_KEY = "zwQ8oSBLFdXGPDzvuhICV9LQ7XsXWzgB";

    AipOcr client;

    public void ready() {
        // 初始化一个AipOcr
        this.client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        this.client.setConnectionTimeoutInMillis(2000);
        this.client.setSocketTimeoutInMillis(60000);
    }

    /**
     * 需要使用者自己去实现的逻辑
     *
     * @param bytes
     * @return
     */
    public abstract JSONObject recogn(byte[] bytes);

    @Override
    public JSONObject recognition(byte[] bytes) {
        return this.recogn(bytes);
    }
}
