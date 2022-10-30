/**
 * @Classname NettyClient
 * @Description TODO
 * @Date 2022/10/19 12:43
 * @Created by 28327
 */

package com.wcl.easysimple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
//        创建事件循环对象
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
//          创建启动对象
            Bootstrap bootstrap = new Bootstrap();
//          参数配置，配置线程组
            bootstrap.group(group)
//                  设置客户端通道的反射类
                    .channel(NioSocketChannel.class)
//                  配置客户端处理器
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("客户端 ok..");
            //远程连接服务端端口
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666);
            //监听关闭事件
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }
}