package com.zhoujunwen.me;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/5/28
 * Time: 下午7:58
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class PlainNioServer {
    public void server(int port) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);

        ServerSocket serverSocket = socketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        serverSocket.bind(address);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes("UTF-8"));
        for (;;) {

        }
    }
}
