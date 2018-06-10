package com.zhoujunwen.me.server;


/**
 * Hello world!
 *
 */
public class AppServer
{
    public static void main( String[] args ) throws Exception {
        System.out.println("start bootserver...");
        if (args.length != 1) {
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }
}
