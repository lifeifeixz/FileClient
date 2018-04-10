package test.ch1;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author flysLi
 * @date 2018/3/22
 */
public class HttpTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://116.62.160.241:8039/api/v1/mgr/complain/getComplainByOrderId?orderId=124123125421321321&role=DRIVER");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        inputStream.close();
        br.close();
    }
}
