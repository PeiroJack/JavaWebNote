# JSON

JavaScript Object  Notation

JavaScript 对象表示法

JSON是轻量级的文本数据交换格式

JSON独立于语言，具有自我描述性

```
{
	"sites":[
	{"name":"慕课网","url":"www.imooc.com"},
	{"name":"百度","url":"www.imooc.com"},
	{"name":"网易","url":"www.163.com"}
	]
}
```

## JSON语法规则

数据由键(key)/值(value)对描述，由逗号分隔

大括号代表一个完整的对象，拥有多个键/值对

中括号保存数组，多个对象之间用逗号分隔



JavaScript中访问JSON

```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var json = [
		{
			"empno": 7369,
			"ename": "李宁",
			"job": "软件工程师",
			"hiredate": "2017-05-12",
			"salary": 13000,
			"dname": "研发部"
		},
		{
			"empno": 7499,
			"ename": "王乐",
			"job": "客户经理",
			"hiredate": "2017-04-22",
			"salary": 10000,
			"dname": "市场部",
			"customers": [
				{
					"cname": "李东"
				},
				{
					"cname": "刘岚"
				}
			]
		}
	];
	console.log(json);
	for(var i=0; i<json.length;i++){
		var emp = json[i];
		document.write("<h1>");
		document.write(emp.empno);
		document.write(","+emp.ename);
		document.write(","+emp.job);
		document.write(","+emp.hiredate);
		document.write(","+emp.dname);
		document.write("</h1>");
		if(emp.customers != null){
			document.write("<h2>---");
			for(var j=0;j<emp.customers.length;j++){
				var customer = emp.customers[j];
				document.write(customer.cname+",");
			}
			document.write("</h2>");
		}
	}
</script>
</head>
<body>

</body>
</html>
```



## JSON与字符串互相转换

在IE8以下的版本不支持，现在几乎所有浏览器都支持

JSON.parse()方法将字符串转换为JSON对象

```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>字符串转JSON</title>
<script type="text/javascript">
	var str="{\"class_name\":\"五年级三班\"}";
	var json = JSON.parse(str);
	console.log(str);
	console.log(json);
	document.write("班级："+json.class_name);
</script>
</head>
<body>

</body>
</html>
```

JSON.stringify()方法将JSON对象转换为字符串

```
<script type="text/javascript">
	var json1 = {"class_name":"五年级四班"};
	var str1 = JSON.stringify(json1);
	console.info(json1);
	console.info(str1);
	var json2 = {};
	json2.class_name = "五年级五班";
	json2.floor = "逸夫楼四层";
	json2.teacher = "王义夫";
	console.info(json2);
</script>
```



## JSON与Java交互

Java的JSON工具包

**FastJson** 阿里巴巴 JSON序列化和反序列化工具包

Jackson国外

Gson谷歌

Json-lib 开源平台的项目

单个对象

```
//FastJSON中提供了JSON对象，完成对象与JSON字符串的互相转换
String json = JSON.toJSONString(employee);
System.out.println(json);
Employee emp = JSON.parseObject(json, Employee.class);
System.out.println(emp.getEname());
```

集合

```
		List emplist = new ArrayList();
		for (int i = 1 ; i <= 100 ; i++) {
			Employee employee = new Employee();
			employee.setEmpno(4488 + i);
			employee.setEname("员工" + i);
			emplist.add(employee);
		}
		String json = JSON.toJSONString(emplist);
		System.out.println(json);
		List<Employee> emps = JSON.parseArray(json , Employee.class);
		for(Employee e : emps) {
			System.out.println(e.getEmpno() + ":" + e.getEname());
		}
```

@JSONField注解

name是在json中代替的名字，format是格式化显示

serialize序列化的意思，false时这个属性不被序列化

```
//@JSONField(format="yyyy-MM-dd HH:mm:ss SSS")
@JSONField(name = "hiredate" , format="yyyy-MM-dd")
private Date hdate;

@JSONField(serialize = false)
private String dname;
```

日期对象的使用

```
Calendar c = Calendar.getInstance();
c.set(2019, 0, 30, 0, 0, 0);
employee.setHdate(c.getTime());
```



