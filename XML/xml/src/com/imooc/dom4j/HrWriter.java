package com.imooc.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class HrWriter {
	public void writeXml() {
		String file = "C:\\Users\\12138\\eclipse-workspace\\xml\\src\\hr.xml";
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			Element root=document.getRootElement();
			Element employee=root.addElement("employee");
			employee.addAttribute("no", "3011");
			Element name=employee.addElement("name");
			name.setText("李铁柱");
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
