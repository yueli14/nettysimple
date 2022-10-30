![](https://github.com/yueli14/image/raw/master/a14.png)

## PRC 调用流程说明

1) 服务消费方(client)以本地调用方式调用服务
2) client stub 接收到调用后负责将方法、参数等封装成能够进行网络传输的消息体
3) client stub 将消息进行编码并发送到服务端
4) server stub 收到消息后进行解码
5) server stub 根据解码结果调用本地的服务
6) 本地服务执行并将结果返回给 server stub
7) server stub 将返回导入结果进行编码并发送至消费方
8) client stub 接收到消息并进行解码
9) 服务消费方(client)得到结果

## 说明设计

![](https://github.com/yueli14/image/raw/master/a15.png)
