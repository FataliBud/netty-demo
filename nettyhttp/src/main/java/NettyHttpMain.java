import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created with IntelliJ IDEA.
 * Date: 2018/8/24
 * Time: 上午12:08
 * Description:
 *
 * @author zjw
 * @version 1.0
 */
public class NettyHttpMain {
    public static void main(String[] args) {
        EventLoopGroup bosserGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //服务端启动辅助类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bosserGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpServerInitializer());
            ChannelFuture channelFuture = bootstrap.bind(8080).sync();

            //等待服务端口关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bosserGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
