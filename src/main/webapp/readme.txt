1, ʹ�� MS-DOS���� servlet
��ʽһ: (���Ƽ�)
    (1) path ��������
        ��� D:\Java\jdk1.7.0_06\bin
    (2) ��� servlet-api.jar ()
        �� D:\apache-tomcat-7.0.37\lib\servlet-api.jar 
        ����
        �� D:\Java\jdk1.7.0_06\jre\lib\ext Ŀ¼��
��ʽ��: (ʹ��������+EditPuls)
    (1) ��д �������ļ� servlet.bat
:: serlvet-api.java
set classpath=%classpath%;D:\apache-tomcat-7.0.37\lib\servlet-api.jar;

:: commons-fileupload 
set classpath=%classpath%;D:\uploadify\WEB-INF\lib\commons-fileupload-1.2.2.jar;
:: commons-io
set classpath=%classpath%;D:\uploadify\WEB-INF\lib\commons-io-2.4.jar;

rem �� MyServlet.java ���뵽 D:\uploadify\WEB-INF\classes Ŀ¼
javac -d D:\uploadify\WEB-INF\classes %1
    (2) ����EditPlus3
        A) ����->��������->�û�����
        B) �ο���ͼ(Servlet_Compile)

2, �������� �޸� ��� MyServlet.class
    (1) server.xml
        λ��: D:\apache-tomcat-7.0.37\conf
    (2) ��������Ŀ¼
        <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">
            ... ...
            <Context path="/uploadify" docBase="D:\uploadify" reloadable="true" />
        </Host>
        ˵��:
            ��� web��Ŀ uploadify
            A) path:  ����Ŀ¼. �� ���� uploadify �� URL·��
                "/", ����վ��(����)
                ��, http://localhost:8080/uploadify
            B) docBase: web��Ŀuploadify��·��
            C) reloadable:������������Ϊtrue��
                tomcat������WEB-INF/classes��WEB-INF/libĿ¼
                �����⵽��class�ļ������µģ����������Զ����¼���WebӦ�á�
