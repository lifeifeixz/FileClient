package server;

import java.io.*;
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
            this.fileReaderAndReturn("D:\\L临时数据\\coupon-06-27-1.html", client);
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

    /**
     * 向浏览器输出文件流
     *
     * @param fileName
     * @param socket
     * @throws IOException
     */
    void fileReaderAndReturn(String fileName, Socket socket) throws IOException {
        if ("/".equals(fileName)) {// 设置欢迎页面，呵呵！
            fileName = "/index.html";
        }
        fileName = fileName.substring(1);
        PrintStream out = new PrintStream(socket.getOutputStream(), true);
        File fileToSend = new File(fileName);

        String fileEx = fileName.substring(fileName.indexOf(".") + 1);
        String contentType = null;
        // 设置返回的内容类型
        // 此处的类型与tomcat/conf/web.xml中配置的mime-mapping类型是一致的。测试之用，就写这么几个。
        if ("htmlhtmxml".indexOf(fileEx) > -1) {
            contentType = "text/html;charset=utf8";
        } else if ("jpegjpggifbpmpng".indexOf(fileEx) > -1) {
            contentType = "application/binary";
        }

        if (fileToSend.exists() && !fileToSend.isDirectory()) {
            // http 协议返回头
            out.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
            out.println("Content-Type:" + contentType);
            out.println("Content-Length:" + fileToSend.length());// 返回内容字节数
            out.println();// 根据 HTTP 协议, 空行将结束头信息

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileToSend);
            } catch (FileNotFoundException e) {
                out.println("<h1>404错误！</h1>" + e.getMessage());
            }
            byte data[];
            try {
                data = new byte[fis.available()];
                fis.read(data);
                out.write(data);
            } catch (IOException e) {
                out.println("<h1>500错误!</h1>" + e.getMessage());
                e.printStackTrace();
            } finally {
                out.close();
                try {
                    fis.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        } else {
            out.println("<h1>404错误！</h1>" + "文件没有找到");
            out.close();

        }

    }
}
