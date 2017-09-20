package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class ContentAction extends ActionSupport{

	private String topic;
	private String content;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String save() throws Exception{
		
		return SUCCESS;
	}
	public String del() throws Exception{
		
		return ERROR;
	}
}
