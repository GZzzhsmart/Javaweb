package com.ht.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ht.pojo.FileUpInfoVo;
import com.ht.pojo.PagingBean;
import com.ht.pojo.TAgency;
import com.ht.pojo.TArticle;
import com.ht.pojo.TArticleType;
import com.ht.service.ArticleService;
import com.ht.service.TArticleTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ArticleService articleService;
	private File file;
	private FileUpInfoVo fileupinfo;
	private TArticle article;
	private List<TArticle> articleslist;
	private TArticleTypeService tArticleTypeService;
	private List<TArticleType> typelist;
	
	public TArticleTypeService gettArticleTypeService() {
		return tArticleTypeService;
	}
	public void settArticleTypeService(TArticleTypeService tArticleTypeService) {
		this.tArticleTypeService = tArticleTypeService;
	}
	public List<TArticleType> getTypelist() {
		return typelist;
	}
	public void setTypelist(List<TArticleType> typelist) {
		this.typelist = typelist;
	}
	public TArticle getArticle() {
		return article;
	}
	public List<TArticle> getArticleslist() {
		return articleslist;
	}
	public void setArticleslist(List<TArticle> articleslist) {
		this.articleslist = articleslist;
	}
	public void setArticle(TArticle article) {
		this.article = article;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public String upfile() throws Exception{
		HttpSession session = request.getSession();
		TAgency tagency = (TAgency)session.getAttribute("tagency");
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		System.out.println(fileupinfo.getDocFileName());
		String newname = getFileName(fileupinfo.getDocFileName());
		article.setLogoString("upfile/"+newname);
		FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		long filename = System.currentTimeMillis();
		String msgContentUrl="upfile/"+filename+".html";
		uploud(article.getContentString(), msgContentUrl);
		article.setCreatedTime(new Date());
		article.setStatusInt(0);
		article.setContenturlString(msgContentUrl);
		article.setJxsidString(tagency.getIdString());
		articleService.add(article);
		paginglist();
		return "upfile";
		
	}
	public FileUpInfoVo getFileupinfo() {
		return fileupinfo;
	}
	public void setFileupinfo(FileUpInfoVo fileupinfo) {
		this.fileupinfo = fileupinfo;
	}
	public String initaddarticle() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(TArticleType.class);
		typelist = tArticleTypeService.pagelist(dc, 0, tArticleTypeService.findtype().size());
		return "initaddarticle";
		
	}
	
	public void uploud(String content,String filename){
		String PAGE_HEAD="<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";
		String PAGE_TAIL="</body></html>";
		content = PAGE_HEAD + content + PAGE_TAIL;
		String savePath = request.getRealPath("/") + filename;
		File file = new File(savePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String pagearticle() throws Exception{
		paginglist();
		return "pagearticle";
	}
	public String allarticlelist() throws Exception{
		paginglist1();
		return "allarticlelist";
		
	}
	public String updasavetearticle() throws Exception{
		String filepath = request.getRealPath("/")+"upfile"; 
		File file1 = new File(filepath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		if(fileupinfo==null){
			fileupinfo = new FileUpInfoVo();
			fileupinfo.setDocFileName(article.getLogoString());
		}else{
			String newname = getFileName(fileupinfo.getDocFileName());
			article.setLogoString("upfile/"+newname);
			FileUtils.copyFile(fileupinfo.getDoc(), new File(filepath,newname));
		}
		String PAGE_HEAD="<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";
		String PAGE_TAIL="</body></html>";
		String content = PAGE_HEAD + article.getContentString() + PAGE_TAIL;
		String savePath = request.getRealPath("/") +article.getContenturlString();
		File file = new File(savePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(article.getContentString());
		articleService.update(article);
		paginglist();
		return "updasavetearticle";
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	private synchronized String getFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}
	
}
