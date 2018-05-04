package test.recogn;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 驾驶证识别demo
 *
 * @author flysLi
 * @date 2018/5/3
 */
public class DriverDist extends AbstractOcr{
    public static final String APP_ID = "11188041";
    public static final String API_KEY = "CrvaqBAOZIopM8nas4bAamxG";
    public static final String SECRET_KEY = "zwQ8oSBLFdXGPDzvuhICV9LQ7XsXWzgB";

    public static void main(String[] args) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        //读取文件流
        File f = new File("D:\\L临时数据\\图片\\驾驶证21.jpg");
        FileInputStream fileInputStream = new FileInputStream(f);
        byte[] bytes = new byte[5 * 1024 * 1024];
        fileInputStream.read(bytes);
        // 调用接口
        JSONObject res = client.drivingLicense(bytes, new HashMap(10));
        System.out.println(res.toString());

    }

    @Override
    public JSONObject recogn(byte[] bytes) {

        return this.client.drivingLicense(bytes,new HashMap(10));
    }
}
