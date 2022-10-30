/**
 * @Classname FIleChannelTest4
 * @Description TODO
 * @Date 2022/6/23 14:33
 * @Created by 28327
 */

package NIOdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FIleChannelTest4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\学习资料\\netty\\1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\学习资料\\netty\\2.jpg");
//获取各个流对应的 filechannel
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();
//使用 transferForm 完成拷贝
        destCh.transferFrom(sourceCh, 0, sourceCh.size());
//关闭相关通道和流
        sourceCh.close();
        destCh.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}