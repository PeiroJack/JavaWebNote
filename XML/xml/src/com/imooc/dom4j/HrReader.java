package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class HrReader {
	public void readXml() {
		String file = "D:/JavaWebNote/XML/xml/src/hr.xml";
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			List<Element> employees = root.elements("employee");
			for(Element employee : employees) {
				Element name=employee.element("name");
				String employeeName = name.getText();
				System.out.println(employeeName);
				System.out.println(employee.elementText("age"));
				System.out.println(employee.elementText("salary"));
				Element department = employee.element("department");
				System.out.println(department.elementText("dname"));
				System.out.println(department.elementText("address"));
				Attribute att=employee.attribute("no");
				System.out.println(att.getText());
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		HrReader hrReader=new HrReader();
		hrReader.readXml();
	}
}
