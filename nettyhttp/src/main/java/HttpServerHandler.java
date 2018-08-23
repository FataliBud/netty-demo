import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

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
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    private HttpRequest request;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            request = (HttpRequest) msg;
            HttpMethod method = request.method();
            String uri = request.uri();
            System.out.println("Uri:" + uri + "method:" + method.name());
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
            System.out.println(buf.toString(UTF_8));

            ByteBuf byteBuf = Unpooled.copiedBuffer("Hello World", UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().add(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

            ctx.writeAndFlush(response);
        }
    }
}
