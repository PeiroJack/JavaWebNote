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





