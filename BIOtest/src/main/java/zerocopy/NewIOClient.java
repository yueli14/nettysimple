/**
 * @Classname NewIOClient
 * @Description TODO
 * @Date 2022/8/27 14:12
 * @Created by 28327
 */

package zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 7001));
        String filename = "protoc-3.6.1-win32.zip";
//得到一个文件 channel
        FileChannel fileChannel = new FileInputStream(filename).getChannel();
//准备发送
        long startTime = System.currentTimeMillis();
//在 linux 下一个 transferTo 方法就可以完成传输
//在 windows 下 一次调用 transferTo 只能发送 8m , 就需要分段传输文件, 而且要主要
//传输时的位置 =》 课后思考... //transferTo 底层使用到零拷贝
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println(" 发 送 的 总 的 字 节 数 =" + transferCount + " 耗 时 :" + (System.currentTimeMillis() - startTime));
//关闭
        fileChannel.close();
    }
}