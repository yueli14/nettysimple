/**
 * @Classname FIleChannelTest5
 * @Description TODO
 * @Date 2022/6/23 15:42
 * @Created by 28327
 */

package NIOdemo;

import java.nio.ByteBuffer;

public class FIleChannelTest5 {
    public static void main(String[] args) {
//创建一个 Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);
//类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putShort((short) 4);
//取出
        buffer.flip();
        System.out.println();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());

    }
}