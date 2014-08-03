1, 使用 MS-DOS编译 servlet
方式一: (不推荐)
    (1) path 环境变量
        添加 D:\Java\jdk1.7.0_06\bin
    (2) 添加 servlet-api.jar ()
        将 D:\apache-tomcat-7.0.37\lib\servlet-api.jar 
        拷贝
        到 D:\Java\jdk1.7.0_06\jre\lib\ext 目录下
方式二: (使用批处理+EditPuls)
    (1) 编写 批处理文件 servlet.bat
:: serlvet-api.java
set classpath=%classpath%;D:\apache-tomcat-7.0.37\lib\servlet-api.jar;

:: commons-fileupload 
set classpath=%classpath%;D:\uploadify\WEB-INF\lib\commons-fileupload-1.2.2.jar;
:: commons-io
set classpath=%classpath%;D:\uploadify\WEB-INF\lib\commons-io-2.4.jar;

rem 将 MyServlet.java 编译到 D:\uploadify\WEB-INF\classes 目录
javac -d D:\uploadify\WEB-INF\classes %1
    (2) 配置EditPlus3
        A) 工具->参数设置->用户工具
        B) 参看截图(Servlet_Compile)

2, 从新载入 修改 后的 MyServlet.class
    (1) server.xml
        位置: D:\apache-tomcat-7.0.37\conf
    (2) 配置虚拟目录
        <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">
            ... ...
            <Context path="/uploadify" docBase="D:\uploadify" reloadable="true" />
        </Host>
        说明:
            添加 web项目 uploadify
            A) path:  虚拟目录. 即 访问 uploadify 的 URL路径
                "/", 代表站点(主机)
                如, http://localhost:8080/uploadify
            B) docBase: web项目uploadify的路径
            C) reloadable:如果这个属性设为true，
                tomcat监视在WEB-INF/classes和WEB-INF/lib目录
                如果监测到有class文件被更新的，服务器会自动重新加载Web应用。
