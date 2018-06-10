# netty-demo

#### 项目介绍
玩转Netty。Netty是一个设计为异步和数据驱动的被广泛使用的Java网络编程框架。

- 设计
  
  - 针对多种传输类型的统一接口——阻塞和非阻塞
  - 简单但更强大的线程模型
  - 真正无连接的数据套接字支持
  - 链接逻辑支持复用
  
- 易用性

  - 大量的Javadoc和代码实例
  - 除了在JDK1.6+的额外限制
  
- 性能

  - 比核心API更好的吞吐量，较低的延时
  - 资源消耗更少，这个得益于共享池和重用
  - 减少内存拷贝
  
- 健壮性
 
  - 消除由于慢，快，或重载连接产生的 OutOfMemoryError
  - 消除经常发现在 NIO 在高速网络中的应用中的不公平的读/写比
  
- 安全

  - 完整的 SSL / TLS 和 StartTLS 的支持
  - 运行在受限的环境例如 Applet 或 OSGI
  
- 社区

  - 发布的更早和更频繁
  - 社区驱动
  
### Java原生的网络编程

### netty写个Echo服务

使用exec-maven-plugin插件启动服务。

服务端的启动命令：

```bash
mvn clean package install #其中install是phase
```

客户端启动命令：

```bash
mvn exec:java -Dexec.mainClass="com.zhoujunwen.me.client.EchoClient" -Dexec.args="localhost 9999" -Dexec.classpathScope=runtime
```


