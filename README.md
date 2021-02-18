# dubbo-samples-lazymodel
# 测试lazy 模式下，consumer 会与provider 建立多个连接的问题

测试说明
1.dubbo-samples-lazymodel 下面编译 mvn clean install -Dmaven.test.skip=true
2.本地启动zk （默认端口 2181 或者可以修改  lazy-provider 和 lazy-consumer 模块下 application.properties 中关于zk配置）
3.启动provider，提供了 HelloService、GreetingService、GoodbyeService 三个服务；默认 dubbo端口 20880
4.启动consumer，默认http端口 8088
5.查询连接情况  netstat -ano |findstr "20880" ，由于是lazy模式，此时没有连接；
6.调用 http://localhost:8088/hello/test1  ，底层调用了HelloService 服务的方法，查询连接情况  netstat -ano |findstr "20880"。此时发现建立 1 个连接；
7.调用 http://localhost:8088/greeting/test2  ，GreetingService 服务的方法，查询连接情况  netstat -ano |findstr "20880"。此时发现建立 2 个连接；
8.调用 http://localhost:8088/goodbye/test3  ，底层调用了HelloService 服务的方法，查询连接情况  netstat -ano |findstr "20880"。此时发现建立 3个连接；

综上所述，在lazy模式下，每个服务都建立了一个连接；
将lazy-consumer 项目 application.properties 内配置修改 为 dubbo.consumer.lazy=false ，则默认始终只有一个连接；
