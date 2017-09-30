package com.ht;

import org.jdom.Document;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public interface Node {

	public static final short ELEMENT_NODE=1;
	public static final short ATTRIBUTE_NODE=2;
	public static final short TEXT_NODE=3;
	public static final short CDATA_SECTION_NODE        = 4;
    public static final short ENTITY_REFERENCE_NODE     = 5;
    public static final short ENTITY_NODE               = 6;
    public static final short PROCESSING_INSTRUCTION_NODE = 7;
    public static final short COMMENT_NODE              = 8;
    public static final short DOCUMENT_NODE             = 9;
    public static final short DOCUMENT_TYPE_NODE        = 10;
    public static final short DOCUMENT_FRAGMENT_NODE    = 11;
    public static final short NOTATION_NODE             = 12;
    
    public String getNodeName();
    public String getNodeValue()throws DOMException;
    public void   setNodeValue(String nodeValue);
    public short  getNodeType();
	public String getNamespaceURI();
    public String getPrefix();
    public void   setPrefix(String prefix)throws DOMException;
    public String getLocalName();

	
	public Node getParentNode();
    public NodeList getChildNodes();
	public Node getFirstChild();
    public Node getLastChild();
    public Node getPreviousSibling();
    public Node getNextSibling();
	public NamedNodeMap getAttributes();
    public Document getOwnerDocument();
    public boolean hasChildNodes();
    public boolean hasAttributes();

	public Node insertBefore(Node newChild, Node refChild)throws DOMException;
    public Node replaceChild(Node newChild, Node oldChild)throws DOMException;
    public Node removeChild(Node oldChild)throws DOMException;
    public Node appendChild(Node newChild)throws DOMException;
     
	public Node cloneNode(boolean deep);

	public void normalize();
    public boolean isSupported(String feature,String version);
	    
}
