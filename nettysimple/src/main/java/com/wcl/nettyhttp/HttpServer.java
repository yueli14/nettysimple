/**
 * @Classname HttpServer
 * @Description TODO
 * @Date 2022/10/19 16:18
 * @Created by 28327
 */

package com.wcl.nettyhttp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HttpServer {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap server = new ServerBootstrap();
            server.group(boosGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyChannelInitializer());
            ChannelFuture channelFuture = server.bind(8080).sync();
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("监听端口 8080 成功");
                    } else {
                        System.out.println("监听端口 8080 失败");
                    }
                }
            });
            channelFuture.channel().closeFuture().sync();

        }finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}