# EL表达式

EL（Expression Language）表达式语言，用于简化JSP的输出

基本语法

```
${表达式}
示例：<h1>学生姓名：${student.name}</h1>
```

EL表达式内置四种作用域对象

忽略书写作用域对象时，EL则按作用域从小到大依次尝试获取

| 作用域对象       | 描述                     |
| ---------------- | ------------------------ |
| pageScope        | 从当前页面取值           |
| requestScope     | 从当前请求中获取属性值   |
| sessionScope     | 从当前对话中获取属性值   |
| applicationScope | 从当前应用获取全局属性值 |

输出

```
${title}
${requestScope.student.name}
${emp.salary+300}
${1<=3 && 2>4}
```

输出参数值

内置param对象来简化参数的输出

```
${param.参数名}
```



JSTL的标签库种类

JSTL按功能划分可分为五类标签库

| 种类                    |
| ----------------------- |
| **核心标签库core**      |
| **格式化输出标签库fmt** |
| SQL操作标签库sql        |
| XML操作标签库xml        |
| 函数标签库function      |

**核心标签库core**

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

JSTL核心标签库在taglibs-standard-impl-1.2.5.jar，

由META-INF/c.tld定义的

.tld 文件是标签库的定义文件



**判断标签**

单分支判断

```
<c:if>

<c:if test="${score >= 60 }">
	<h1 style="color: green">恭喜，你已通过测试</h1>
</c:if>
```

多分支判断

```
<c:choose>

<c:when>

<c:otherwise>

<c:choose>
	<c:when test="${grade == 'A' }">
		<h2>你很优秀</h2>
	</c:when>
	<c:when test="${grade == 'B' }">
		<h2>不错哟</h2>
	</c:when>
	<c:when test="${grade == 'C' }">
		<h2>水平一般，需要提高</h2>
	</c:when>
	<c:when test="${grade == 'D' }">
		<h2>需要努力啦，不要气馁</h2>
	</c:when>
	<c:otherwise>
		<h2>一切随缘</h2>
	</c:otherwise>
</c:choose>
```

EL判断字符串用 ==，不用equals

字符串用单引号 ''



**遍历集合**

`<c:forEach>`标签用于遍历集合（Collection）中的每一个对象

```
<c:forEach var="p" items="${persons}" varStatus="idx">
 第${idx.index + 1}位 <br/>
 姓名：${p.name} 性别：${p.sex} 年龄：${p.age}
</c:forEach>
```

```
<c:forEach items="${requestScope.companies }" var="c" varStatus = "idx" >
	<h2 style="color:red">${idx.index+1}.${c.cname }-${c.url }</h2>
</c:forEach>
```

```
1.腾讯-www.tencent.com
2.百度-www.baidu.com
3.慕课网-www.imooc.com
```







