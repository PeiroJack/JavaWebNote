package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XPathTestor {
	public void xpath(String xpathExp) {
		String file="D:\\JavaWebNote\\XML\\xml\\src\\hr.xml";
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			List<Node> nodes = document.selectNodes(xpathExp);
			for(Node node:nodes) {
				Element employee = (Element)node;
				System.out.println(employee.attributeValue("no"));
				System.out.println(employee.elementText("name"));
				System.out.println(employee.elementText("age"));
				System.out.println(employee.elementText("salary"));
				Element department = employee.element("department");
				System.out.println(department.elementText("dname"));
				System.out.println(department.elementText("address"));
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		XPathTestor testor = new XPathTestor();
		testor.xpath("//employee");
	}
}
