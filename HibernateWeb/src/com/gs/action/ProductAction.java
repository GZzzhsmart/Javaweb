package com.gs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.gs.bean.Product;
import com.gs.common.bean.ControllerResult;
import com.gs.common.bean.Pager4EasyUI;
import com.gs.service.ProductService;
import com.gs.service.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -2837543750268792387L;
	
	private ProductService productService;
	private Product product;
	private int total; // 返回给easyui的总页数
	private List<Product> rows; // 返回给easyui的结果
	private ControllerResult result;
	
	private int id;
	
	private HttpServletRequest req;
	
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
	
	public ProductAction() {
		productService = new ProductServiceImpl();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getTotal() {
		return total;
	}

	public List<Product> getRows() {
		return rows;
	}

	public ControllerResult getResult() {
		return result;
	}
	
	public void setId(int id) {
		this.id = id;
	} 
	
	public String add() {
		productService.add(product);
		result = ControllerResult.getSuccessResult("添加成功");
		return "add";
	}
	
	public String queryById() {
		product = productService.queryById(id);
		return "query";
	}
	
	public String queryAll() {
		String pageNoStr = req.getParameter("page");
		String pageSizeStr = req.getParameter("rows");
		Pager4EasyUI<Product> pager = new Pager4EasyUI<Product>();
		if (pageNoStr !=null) {
			pager.setPageNo(Integer.valueOf(pageNoStr));
			pager.setPageSize(Integer.valueOf(pageSizeStr));
		}
		pager = productService.queryAll(pager);
		pager.setTotal(productService.count());
		rows = pager.getRows();
		total = pager.getTotal();
		return "all";
	}
	
	public String update() {
		productService.update(product);
		result = ControllerResult.getSuccessResult("更新成功");
		return "update";
	}
	
	public String del() {
		product = new Product();
		product.setId(id);
		productService.delete(product);
		result = ControllerResult.getSuccessResult("删除成功");
		return "delete";
	}

}
