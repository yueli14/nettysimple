/**
 * @Classname MyChannelInitializer
 * @Description TODO
 * @Date 2022/10/19 16:23
 * @Created by 28327
 */

package com.wcl.nettyhttp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import io.netty.handler.codec.http.HttpServerCodec;

public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //向管道加入处理器

        //得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();
        //1. HttpServerCodec 是netty 提供的处理http的 编-解码器
        pipeline.addLast("编码器", new HttpServerCodec() );
        pipeline.addLast("自定义处理器",new MyHandler());
        System.out.println("Ok");
    }
}