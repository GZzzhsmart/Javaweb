package com.java.activiti.controller;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.java.activiti.model.PageInfo;
import com.java.activiti.util.DateJsonValueProcessor;
import com.java.activiti.util.ResponseUtil;

/**
 * 流程部署管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/deploy")
public class DeployController {
		
	//注入activitiService服务
	@Resource
	private RepositoryService repositoryService;
	
	/**
	 * 分页查询流程
	 * @param rows
	 * @param page
	 * @param s_name
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deployPage")
	public String deployPage(String rows,String page,String s_name,HttpServletResponse response) throws Exception{
		if(s_name==null){
			s_name="";
		}
		PageInfo pageInfo=new PageInfo();
		//填充每页显示数量
		Integer sizePage=Integer.parseInt(rows);
		pageInfo.setPageSize(sizePage);
		// 第几页
		String pageIndex = page;
		if (pageIndex == null || pageIndex == "") {
				pageIndex = "1";
		}
		pageInfo.setPageIndex((Integer.parseInt(pageIndex) - 1)
				* sizePage);
		//取得总数量
		long deployCount=repositoryService.createDeploymentQuery().deploymentNameLike("%"+s_name+"%")
				.count();
		
		List<Deployment> deployList=repositoryService.createDeploymentQuery()//创建流程查询实例
				.orderByDeploymenTime().desc()  //降序
				.deploymentNameLike("%"+s_name+"%")   //根据Name模糊查询
				.listPage(pageInfo.getPageIndex(), pageInfo.getPageSize());
		
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"resources"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(deployList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", deployCount);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 添上传流程部署ZIP文件
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addDeploy")
	public String addDeploy(HttpServletResponse response,MultipartFile deployFile) throws Exception{
		repositoryService.createDeployment() //创建部署
		.name(deployFile.getOriginalFilename())	//需要部署流程名称
		.addZipInputStream(new ZipInputStream(deployFile.getInputStream()))//添加ZIP输入流
		.deploy();//开始部署
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 批量删除流程
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/delDeploy")
	public String delDeploy(HttpServletResponse response,String ids) throws Exception{
		//拆分字符串
		String[] idsStr=ids.split(",");
		for(String str:idsStr){
			repositoryService.deleteDeployment(str, true);
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
