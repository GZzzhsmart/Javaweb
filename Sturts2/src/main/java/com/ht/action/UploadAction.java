package com.ht.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String targetdir; //保存路径
	private String targetfilename; //保存的文件名
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getTargetdir() {
		return targetdir;
	}
	public void setTargetdir(String targetdir) {
		this.targetdir = targetdir;
	}
	public String getTargetfilename() {
		return targetfilename;
	}
	public void setTargetfilename(String targetfilename) {
		this.targetfilename = targetfilename;
	}
	@Override
	public String execute() throws Exception {
		
		//获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取tomcat中对应的绝对路径
		String path = request.getRealPath("/upload");
		targetdir = path;
		//获取文件的扩展名称
		int pos = uploadFileName.lastIndexOf('.');
		String ext = uploadFileName.substring(pos); 
		targetfilename = System.nanoTime()+ext;
		System.out.println("title="+title);
		System.out.println("upload="+upload.getName());
		System.out.println("filename="+uploadFileName);
		System.out.println("contenttype="+uploadContentType);
		System.out.println("targetdir="+targetdir);
		System.out.println("targetfilename="+targetfilename);
		// 把doc内容复制到target
		FileUtils.copyFile(upload, new File(targetdir,targetfilename));
		return SUCCESS;
	}
	
}