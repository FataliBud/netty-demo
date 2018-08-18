package com.zhoujunwen.socket.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/8/18
 * Time: 上午9:23
 * Description:
 *
 * @author zjw
 * @version 1.0
 */
public class ClientMain {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;


    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);
        new Thread(()-> {
            System.out.println("客户端启动成功");
            while (true) {
                String message  = "hello world";
                System.out.println("发往服务端的数据：" + message);
                try {
                    socket.getOutputStream().write(message.getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("写数据出错");
                }
                sleep();
            }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
