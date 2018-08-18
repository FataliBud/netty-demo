package com.zhoujunwen.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/8/18
 * Time: 上午9:01
 * Description:
 *
 * @author zjw
 * @version 1.0
 */
public class Server {
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务启动端口: " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务启动失败");
        }
    }
    public void start() {
        new Thread(() -> doStart()).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("服务端异常");
            }
        }
    }
}