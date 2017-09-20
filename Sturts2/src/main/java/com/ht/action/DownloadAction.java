package com.ht.action;
import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{

	private String fileList[];
	//要下载的文件及路径
	private String path;
	private String contentType;
	private String filename;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String list() throws Exception{
		//获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取文件路径
		String path = request.getRealPath("/upload");
		File file = new File(path);
		//获取当前路径的所有文件
		fileList = file.list();
		return INPUT;
	}
	//返回一个InputStream类型,实现文件下载的函数
	public InputStream getInputStream() {
		return ServletActionContext.getServletContext().getResourceAsStream(path);
	}

	public String down() throws Exception{
		
		//解决下载的中文文件名问题
//		filename = java.net.URLEncoder.encode(filename,"utf-8");
		filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
		path = "upload/"+filename;
		System.out.println("path="+path);
		System.out.println("filename="+filename);
		contentType="image/bmp,image/png,image/gif,image/jpeg";
		
		return SUCCESS;
	}
	public String[] getFileList() {
		return fileList;
	}
	public void setFileList(String[] fileList) {
		this.fileList = fileList;
	}
}
