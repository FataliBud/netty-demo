import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;


import java.net.InetSocketAddress;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/8/24
 * Time: 上午12:23
 * Description:
 *
 * @author zjw
 * @version 1.0
 */
public class HttpServerChannelHandler0 extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

        InetSocketAddress socketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        System.out.println("远程地址：" + socketAddress.getHostName());

        FullHttpRequest request = msg;

        System.out.println("请求方法名称:" + request.method().name());

        System.out.println("uri:" + request.uri());
        ByteBuf buf = request.content();
        System.out.print(buf.toString(CharsetUtil.UTF_8));


        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
        response.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        response.headers().add(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

        ctx.writeAndFlush(response);
    }

}
