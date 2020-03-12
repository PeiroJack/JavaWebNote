访问 http://localhost:8080/FirstServlet/ShopServlet?category=book 成功

![1](D:\JavaWebNote\Servlet\img\1.png)

而访问 http://localhost:8080/ServletProj/ShopServlet?category=book 出错

![3](D:\JavaWebNote\Servlet\img\3.png)

因为ServletProj不是我们所导入的工程文件名

![2](D:\JavaWebNote\Servlet\img\2.png)



在Servlet中获取的参数是字符串类型，需要使用Integer.parseInt(String s)方法转换为整型再进
行计算。