package com.ht;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Attribute;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class TestJDOM1 {

	public TestJDOM1() {
		
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Element rootElement = new Element("MyInfo");
		Document myDocument = new Document(rootElement);
		Attribute rootAttri = new Attribute("comment", "introduce myself");
		rootElement.setAttribute(rootAttri);
		rootElement.addContent((Content) (new Element("name").setText("kingwong")));
		rootElement.addContent(new Element("sex").setAttribute("value", "male"));
	    Element telement = new Element("telephone").setText("18720865791");
	    rootElement.addContent((Content) (new Element("contact").addContent(telement)));
	    XMLOutputter xmlOut = new XMLOutputter(Format.getPrettyFormat());
	    try {
			xmlOut.output(myDocument, System.out);
			FileWriter writer = new FileWriter("myFile.xml");
			xmlOut.output(myDocument, System.out);
			writer.close();
			xmlOut.output(rootElement.getChild("name"), System.out);
			String outString = xmlOut.outputString(myDocument);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
