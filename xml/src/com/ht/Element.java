package com.ht;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;

public interface Element extends Node{

	public String getTagName();
	//取得元素
    public NodeList getElementsByTagName(String name);
    public NodeList getElementsByTagNameNS(String namespaceURI, 
                                           String localName);
    
	//取得属性
    public String getAttribute(String name);

    public void setAttribute(String name,String value)throws DOMException;
    public void removeAttribute(String name)throws DOMException;

    public Attr getAttributeNode(String name);

    public Attr setAttributeNode(Attr newAttr)throws DOMException;

    public Attr removeAttributeNode(Attr oldAttr)throws DOMException;

    public String getAttributeNS(String namespaceURI,String localName);

    public void setAttributeNS(String namespaceURI, String qualifiedName,String value)throws DOMException;

    public void removeAttributeNS(String namespaceURI,String localName)throws DOMException;
    public Attr getAttributeNodeNS(String namespaceURI,String localName);

    public Attr setAttributeNodeNS(Attr newAttr)throws DOMException;

    public boolean hasAttribute(String name);

    public boolean hasAttributeNS(String namespaceURI,String localName);

}
