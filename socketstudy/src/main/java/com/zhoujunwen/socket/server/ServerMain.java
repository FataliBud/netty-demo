package com.zhoujunwen.socket.server;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/8/18
 * Time: 上午8:59
 * Description:
 *
 * @author zjw
 * @version 1.0
 */
public class ServerMain {
    private static int  SERVER_PORT = 8080;
    public static void main(String[] args) {
        Server server = new Server(SERVER_PORT);
        server.start();

    }
}
