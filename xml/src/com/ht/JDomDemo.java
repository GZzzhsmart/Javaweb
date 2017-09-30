package com.ht;

import java.util.List;
import java.io.File;
import java.io.FileWriter;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JDomDemo {

	public void readXML(){
		//��������
		SAXBuilder sax = new SAXBuilder();
		//������Ҫ�������ļ�
		try {
			File file = new File("notebook.xml");
			//����document����
			Document doc = sax.build(file);
			//��ȡ���ڵ�
			Element root = doc.detachRootElement();
			display(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void display(Element root){
		//��ȡ���ڵ���ӽڵ�
		List<Element> children= root.getChildren();
		for (Element child : children) {
			//��ȡ�ڵ������
			List<Attribute> attrs = child.getAttributes();
			System.out.print("<"+child.getName()+" ");
			if(attrs!=null && attrs.size()>0){
				for (Attribute att : attrs) {
					System.out.print(att.getName()+"="+att.getValue()+" ");
				}
			}
			System.out.print("");
			//��ȡ�ڵ��ֵ
			if(child.getChildren().size()>0){
				System.out.println("");
				display(child);
				System.out.println("</"+child.getName()+">");
			}else {
				System.out.println(child.getValue()+"</"+child.getName()+">");
			}
		}
	}
	
	//����XML�ļ�
	@SuppressWarnings("unused")
	public void writeXMLFile(){
		SAXBuilder sax = new SAXBuilder();
		try {
			//����Ҷ��Ԫ��
			Element username = new Element("username");
			//���ڵ㸳ֵ
			username.setText("С����");
			Element age = new Element("age");
			age.setText("22");
			Element sex = new Element("sex");
			sex.setText("��");
			Element cardno = new Element("cardno");
			cardno.setText("362426199801160013");
			Element hobbit = new Element("hobbit");
			hobbit.setText("����");
			//�������ڵ�
			Element person = new Element("person");
			Attribute attr = new Attribute("���","P001");
			person.setAttribute(attr);
			//���ӽڵ���ӵ����ڵ���ȥ
			person.addContent(username);
			person.addContent(age);
			person.addContent(sex);
			person.addContent(cardno);
			person.addContent(hobbit);
			//�������ڵ�
			Element persons = new Element("persons");
			persons.addContent(person);
			//����XML�ĵ����󣬰Ѹ��ڵ㴫�����캯��
			Document newDoc = new Document(persons);
			//���ĵ����ݸ�ʽ��ΪXML�ļ�����ʽ
			XMLOutputter output = new XMLOutputter(Format.getPrettyFormat().setEncoding("gbk"));
			//��������ļ�
			FileWriter write = new FileWriter(new File("persons.xml"));
			//���浽�ļ�
			output.output(newDoc, write);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JDomDemo jdom = new JDomDemo();
		jdom.writeXMLFile();
	}
}
