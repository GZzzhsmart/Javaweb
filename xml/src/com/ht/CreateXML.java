package com.ht;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CreateXML {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		File docFile = new File("orders.xml");
		Document doc = null;
		//create new Document , output  after change dom
		Document newdoc = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			newdoc = builder.newDocument();
			doc = builder.parse(docFile);
		} catch (javax.xml.parsers.ParserConfigurationException pce) {
			System.out.println("The parser was not configured correctly.");
			System.exit(1);
		}catch (java.io.IOException ie) {
            System.out.println("Cannot read input file.");
            System.exit(1);
        } catch (org.xml.sax.SAXException se) {
            System.out.println("Problem parsing the file.");
            System.exit(1);
        } catch (java.lang.IllegalArgumentException ae) {
            System.out.println("Please specify an XML source.");
            System.exit(1);
        }
        
        Element newRoot = newdoc.createElement("processedOrders");
        NodeList processedOrders = doc.getElementsByTagName("order");
        for(int orderNum=0;orderNum<processedOrders.getLength();orderNum++){
        	Element thisOrder = (Element)processedOrders.item(orderNum);
        	Element customerid =(Element) thisOrder.getElementsByTagName("customerid").item(0);
            String limit = customerid.getAttributeNode("limit").getNodeValue();
            double limitDbl = new Double(limit).doubleValue();
            Element newOrder = newdoc.createElement("order");
            Element newStatus = newdoc.createElement("status");
            newStatus.appendChild(newdoc.createTextNode("REJECTED"));
            Element newCustomer = newdoc.createElement("customerid");
            String oldCustomer = customerid.getFirstChild().getNodeValue();
            newCustomer.appendChild(newdoc.createTextNode(oldCustomer));
            Element newTotal = newdoc.createElement("total");
            newTotal.appendChild(newdoc.createTextNode("11233"));
            newOrder.appendChild(newStatus);
            newOrder.appendChild(newCustomer);
            newOrder.appendChild(newTotal);
            newRoot.appendChild(newOrder);
        }
        newdoc.appendChild(newRoot);
        System.out.print(newRoot.toString());
        
        try {
			File newFile = new File("processedOrders.xml");
			FileWriter newFileStream = new FileWriter(newFile);
			newFileStream.write("<?xml version=\"1.0\"?>");
			newFileStream.write(newRoot.toString());
			newFileStream.close();
		} catch (IOException e) {
			System.out.println("Can't write new file.");
		}
	}
}
