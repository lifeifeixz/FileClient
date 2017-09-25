package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by flysLi on 2017/9/25.
 * 一个处理者
 */
@SuppressWarnings("all")
public class HandlerMouse implements Runnable {
    private Socket client;
    public HandlerMouse() {
    }

    public HandlerMouse(Socket socket) {
        this.client = client;
    }

    public void run() {
        try {
            RequestMouse request = new RequestMouse();
            // 第一阶段: 打开输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // 读取第一行, 请求地址
            String line = in.readLine();
            String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/') - 5);
            // 获得请求的资源的地址
            resource = URLDecoder.decode(resource, "UTF-8");// 反编码
            // 获取请求方法, GET 或者 POST
            String method = new StringTokenizer(line).nextElement().toString();
            request.setMethod(method);
            // 读取浏览器发送过来的请求参数头部信息
            while ((line = in.readLine()) != null) {
                if (line.equals(""))
                    break;
            }
            request.setResource(resource);
            String params = null;
            if (resource.indexOf("?") > -1) {
                params = resource
                        .substring(resource.indexOf("?") + 1);
                resource = resource.substring(0, resource
                        .indexOf("?"));
            }
            // 显示 POST 表单提交的内容, 这个内容位于请求的主体部分
            if ("POST".equalsIgnoreCase(method)) {
                if (params != null) {
                    params += "&" + in.readLine();
                } else {
                    params = in.readLine();
                }
            }
            request.setParams(this.analysisParams(params));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析请求中的参数
     *
     * @param params
     * @throws IOException
     */
    Map<String, Object> analysisParams(String params) throws IOException {
        if (params == null) {
            return null;
        }
        Map<String, Object> m = new HashMap<String, Object>();
        String[] maps = params.split("&");
        for (String temp : maps) {
            String[] map = temp.split("=");
            m.put(map[0], map[1]);
        }
        return m;
    }
}
