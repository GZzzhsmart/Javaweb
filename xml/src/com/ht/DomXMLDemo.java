package com.ht;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("unused")
public class DomXMLDemo {

	public void readXMLFile(){
		Document doc=null;
		//��������ʵ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//�Ƿ����XML�ļ����ݵ���Ч��
		dbf.setValidating(false);
		try {
			//�����ĵ�����
			DocumentBuilder db = dbf.newDocumentBuilder();
			File file = new File("notebook.xml"); 
			//����xml�ĵ�
			doc = db.parse(file);
			//��ȡ���ڵ�
			Node root = doc.getFirstChild();
			display(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void display(Node root){
		System.out.println(root.getNodeName());
		NodeList nodeArr = root.getChildNodes();
		for(int i=0;i<nodeArr.getLength();i++){
			Node child = nodeArr.item(i);
			String val = child.getTextContent().trim(); 
			if(!child.getNodeName().equals("#text")){
				if(child.getChildNodes().getLength()>1){
					display(child); 
				}else{
					System.out.println(child.getNodeName()+"="+child.getTextContent());
				}
				 NamedNodeMap attrs = child.getAttributes();
				 if(attrs==null || attrs.getLength()==0){
					 continue;
				 }
				 System.out.print(child.getNodeName()+"�����ԣ�");
				 for(int j=0;j<attrs.getLength();j++){
					 Node atrr = attrs.item(j);
					 System.out.print(atrr.getNodeName()+"="+atrr.getTextContent());
				 }
				 System.out.println();
			}else if(!val.equals("")){
				System.out.println("#text="+val);
			}
		}
	}
	
	public static void main(String[] args) {
		new DomXMLDemo().readXMLFile();
	}
}
