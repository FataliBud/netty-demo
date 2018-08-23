import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * Created with IntelliJ IDEA.
 * Date: 2018/8/24
 * Time: 上午12:16
 * Description:
 *
 * @author zjw
 * @version 1.0
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //处理http消息的编解码
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        //添加自定义的ChannelHandler
        // 方法1
//        pipeline.addLast("httpServerHandler", new HttpServerChannelHandler());
        // 方法2 对于将请求合并为一个FullRequest是需要代码实现的，然而这里我们并不需要我们自己动手去实现，Netty
        // 为我们提供了一个HttpObjectAggregator类，这个ChannelHandler作用就是将请求转换为单一的 FullHttpRequest
        pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
        pipeline.addLast("httpServerHandler", new HttpServerChannelHandler0());
    }
}
