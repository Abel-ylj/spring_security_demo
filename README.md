## SpringSecurity

- 在web.xml中注册一个Filter，

    通过该Filter，进入SpringSecurity的逻辑

- Filter在 Servlet之前执行嘛，也好理解。

    先将请求在Filter中进行认证授权，再将请求放过，进入后面的SpringMVC的前置处理器Servlet

    

