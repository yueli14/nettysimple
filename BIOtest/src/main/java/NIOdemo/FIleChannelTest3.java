/**
 * @Classname FIleChannelTest3
 * @Description TODO
 * @Date 2022/6/23 14:27
 * @Created by 28327
 */

package NIOdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FIleChannelTest3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\学习资料\\netty\\text.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\学习资料\\netty\\text2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) { //循环读取
            //这里有一个重要的操作，一定不要忘了
        /*
        public final Buffer clear() {
        position = 0;
        limit = capacity;
        mark = -1;
        return this;
        }
        */
            byteBuffer.clear(); //清空 buffer
            int read = fileChannel01.read(byteBuffer);
            System.out.println("read =" + read);
            if (read == -1) { //表示读完
                break;
            }
            //将 buffer 中的数据写入到 fileChannel02 -- 2.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }
        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();

    }
}