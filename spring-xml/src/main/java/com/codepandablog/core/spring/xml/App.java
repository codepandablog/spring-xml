package com.codepandablog.core.spring.xml;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codepandablog.core.spring.xml.bean.Customer;

/**
 * Hello world!
 *
 */
public class App {
	private static final String XML_FILE_NAME = "customer.xml";
	public static void main(String[] args) throws IOException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlConverter converter = (XmlConverter) appContext.getBean("xmlConverter");
		
		Customer customer = new Customer();
		customer.setName("Hem");
		customer.setAge(24);
		customer.setFlag(true);
		customer.setAddress("This is address");
		
		System.out.println("Convert Object to XML!");
		//from object to XML file
		converter.convertFromObjectToXML(customer, XML_FILE_NAME);
		System.out.println("Done \n");
		
		System.out.println("Convert XML back to Object!");
		//from XML to object
		Customer customer2 = (Customer)converter.convertFromXMLToObject(XML_FILE_NAME);
		System.out.println(customer2);
		System.out.println("Done");
	}
}
