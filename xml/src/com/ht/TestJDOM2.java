package com.ht;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class TestJDOM2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build("myFile.xml");
			Element root = doc.getRootElement();
			String str1 = root.getAttributeValue("comment");
			String str2 = root.getChild("sex").getAttributeValue("value");
			String str3 = root.getChildText("name");
			String str4 = root.getChild("contact").getChildText("telephone");
			Element inputElement = root.getChild("contact");
			 inputElement.addContent(new Element("email").setAttribute("value","wanghua@cyberobject.com"));
			 XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
			 String outstr = xmlout.outputString(root);
			 System.out.println(outstr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
