/**
 * @Classname FIleChannelTest2
 * @Description TODO
 * @Date 2022/6/23 14:13
 * @Created by 28327
 */

package NIOdemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FIleChannelTest2 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\学习资料\\netty\\text.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
//        得到频道
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        //读入频道
        fileChannel.read(buffer);
        System.out.println(new String(buffer.array()));
        fileInputStream.close();
    }
}