## SpringSecurity

- 在web.xml中注册一个Filter，

    通过该Filter，进入SpringSecurity的逻辑

- Filter在 Servlet之前执行嘛，也好理解。

    先将请求在Filter中进行认证授权，再将请求放过，进入后面的SpringMVC的前置处理器Servlet

    

### 用户认证逻辑

![image-20210121191709405](https://yljnote.oss-cn-hangzhou.aliyuncs.com/2021-01-21-111710.png)

### 整体认证鉴权框架

![image-20210121191840583](https://yljnote.oss-cn-hangzhou.aliyuncs.com/2021-01-21-111841.png)