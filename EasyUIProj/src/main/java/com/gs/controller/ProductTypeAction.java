package com.gs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.gs.bean.ProductType;
import com.gs.common.bean.Constants;
import com.gs.common.bean.ControllerResult;
import com.gs.common.bean.Pager4EasyUI;
import com.gs.service.ProductTypeService;
import com.gs.service.ProductTypeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ProductTypeAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = -352462339245312309L;
	private HttpServletRequest request;
	private ProductType productType;
	private int page;
	private ProductTypeService productTypeService;
	private int id;
	private int total;
	private List<ProductType> rows;
	private ControllerResult controllerResult;
	
	
	public ProductTypeAction() {
		this.productTypeService=new ProductTypeServiceImpl();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotal() {
		return total;
	}

	public List<ProductType> getRows() {
		return rows;
	}

	public ControllerResult getControllerResult() {
		return controllerResult;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductType getProductType() {
		return productType;
	}


	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	//新增
	public String add() throws Exception{
		productTypeService.add(productType);
		controllerResult=ControllerResult.getSuccessResult("成功添加商品");
		return "add";
	}
	//修改
	public String update() throws Exception{
		productTypeService.update(productType);
		controllerResult = ControllerResult.getSuccessResult("成功修改商品类型");
		return "update";
	}
	
	public String pager() throws Exception{
		Pager4EasyUI<ProductType> pager=new Pager4EasyUI<ProductType>();
		pager.setPage(page);
		pager.setPageSize(Integer.parseInt(request.getParameter("rows")));
		pager=productTypeService.queryByPager(pager);
		pager.setTotal(productTypeService.count());
		total=pager.getTotal();
		rows=pager.getRows();
		return "pager";
	}
	//冻结
	public String inactive() {
		productTypeService.validById(id, Constants.VALID_F);
		controllerResult = ControllerResult.getSuccessResult("成功冻结商品类型");
		return "inactive";
	}
	//激活
	public String active() {
		productTypeService.validById(id, Constants.VALID_Y);
		controllerResult = ControllerResult.getSuccessResult("成功激活商品类型");
		return "active";
	}
	
}
