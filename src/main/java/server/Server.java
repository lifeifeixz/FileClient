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

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public class Server {
    ServerSocket serverSocket;// 服务器Socket
    private static int PORT = 8000;

    public Server() {
        //默认监听8888端口
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
        System.currentTimeMillis();
        System.out.println("");
        while (true) {
            try {
                Socket client = null;// 客户Socket
                client = serverSocket.accept();// 客户机(这里是 IE 等浏览器)已经连接到当前服务器
                if (client != null) {
                    System.out.println("连接到服务器的用户:" + client);
                    new Thread(new HandlerMouse(client));
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
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("这是一个简单的web服务器 ，端口是： 80.");
            } else if (args.length == 1) {
                PORT = Integer.parseInt(args[0]);
            }
        } catch (Exception ex) {
            System.err.println("服务器初始化错误" + ex.getMessage());
        }
        new Server(PORT).run();
    }
}
