/**
 * @Classname FIleChannelTest
 * @Description TODO
 * @Date 2022/6/23 13:55
 * @Created by 28327
 */

package NIOdemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FIleChannelTest {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\学习资料\\netty\\text.txt");
//        得到频道
        FileChannel fileChannel = fileOutputStream.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //string
        String str ="hello,world";
        //将字符串放入buffer
        buffer.put(str.getBytes(StandardCharsets.UTF_8));
        //对 byteBuffer 进行 flip
        buffer.flip();
        //写入频道
        fileChannel.write(buffer);
        fileOutputStream.close();
    }
}