/**
 * 监听端口
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 数据
 */
package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public class Server {
    ServerSocket serverSocket;// 服务器Socket

    public Server() {
        //默认监听8888端口
        this(8888);
    }

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 运行服务器主线程, 监听客户端请求并返回响应.
     */
    public void run() {
        while (true) {
            try {
                Socket client = null;// 客户Socket
                client = serverSocket.accept();// 客户机(这里是 IE 等浏览器)已经连接到当前服务器
                if (client != null) {
                    System.out.println("连接到服务器的用户:" + client);
                    try {
                        // 第一阶段: 打开输入流
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(client.getInputStream()));
                        System.out.println("客户端发送的请求信息: ***************");
                        // 读取第一行, 请求地址
                        System.out.println("http协议头部信息：");
                        String line = in.readLine();
                        System.out.println(line);
                        String resource = line.substring(line.indexOf('/'),
                                line.lastIndexOf('/') - 5);
                        // 获得请求的资源的地址
                        resource = URLDecoder.decode(resource, "UTF-8");// 反编码

                        String method = new StringTokenizer(line).nextElement()
                                .toString();// 获取请求方法, GET 或者 POST

                        // 读取浏览器发送过来的请求参数头部信息
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);

                            if (line.equals(""))
                                break;
                        }

                        System.out.println("http协议头部结束 ***************");
                        System.out.println("用户请求的资源是:" + resource);
                        System.out.println("请求的类型是: " + method);

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

                        System.out.println("打印提交的数据：");
                        printParams(params);

                        // 读取资源并返回给客户端
                        fileReaderAndReturn(resource, client);
                        // 关闭客户端链接
                        client.close();
                        System.out.println("客户端返回完成！");
                    } catch (Exception e) {
                        System.out.println("HTTP服务器错误:" + e.getMessage());
                    }
                }

            } catch (Exception e) {
                System.out.println("HTTP服务器错误:" + e.getMessage());
            }
        }
    }
    /**
     * 读取一个文件的内容并返回给浏览器端.
     *
     * @param fileName 文件名
     * @param socket   客户端 socket.
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

    void printParams(String params) throws IOException {
        if (params == null) {
            return;
        }
        String[] maps = params.split("&");
        for (String temp : maps) {
            String[] map = temp.split("=");
            System.out.println(map[0] + "==" + map[1]);
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
