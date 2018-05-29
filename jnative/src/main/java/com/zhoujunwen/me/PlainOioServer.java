package com.zhoujunwen.me;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/5/28
 * Time: 下午7:44
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class PlainOioServer {
    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        for (;;) {
            try (final Socket clientSocket = socket.accept()) {
                System.out.println("Accepted connection from " + clientSocket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out = null;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes("UTF-8"));
                            out.flush();
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
}
