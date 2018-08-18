package com.zhoujunwen.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/8/18
 * Time: 上午9:06
 * Description:
 *
 * @author zjw
 * @version 1.0
 */
public class ClientHandler {
    private Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        System.out.println("新客户接入: " + socket.getInetAddress().getHostName());
        new Thread(this::doStart).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[1024];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len, UTF_8);
                    System.out.println("客户端传来的消息" + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
