package com.ht.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ht.vo.NationVo;
import com.opensymphony.xwork2.ActionSupport;

public class NationAction extends ActionSupport{
	/**
	 * 在action类中定义的所有成员变量,系统会自动设置为request变量(setAttribute)
	 * */
	private List<NationVo> nationList;
	private int nationid;
	private int[] nationid1; 
	private int nationid2;
	private String sex[];
	private Map<Integer, String> nationMap;
	public String[] getSex() {
		return sex;
	}

	public void setSex(String[] sex) {
		this.sex = sex;
	}

	public int getNationid2() {
		return nationid2;
	}

	public void setNationid2(int nationid2) {
		this.nationid2 = nationid2;
	}

	public int getNationid() {
		return nationid;
	}

	public void setNationid(int nationid) {
		this.nationid = nationid;
	}

	public int[] getNationid1() {
		return nationid1;
	}

	public void setNationid1(int[] nationid1) {
		this.nationid1 = nationid1;
	}

	public List<NationVo> getNationList() {
		return nationList;
	}

	public void setNationList(List<NationVo> nationList) {
		this.nationList = nationList;
	}

	public String list() throws Exception{
		nationList = new ArrayList<NationVo>();
		NationVo n1 = new NationVo(1,"汉族");
		NationVo n2 = new NationVo(2,"苗族");
		NationVo n3 = new NationVo(3,"藏族");
		NationVo n4 = new NationVo(4,"高山族");
		NationVo n5 = new NationVo(5,"朝鲜族");
		NationVo n6 = new NationVo(6,"其他民族");
		nationList.add(n1);
		nationList.add(n2);
		nationList.add(n3);
		nationList.add(n4);
		nationList.add(n5);
		nationList.add(n6);
		nationid1 = new int[]{1,3,5};
		nationid2=4;
		sex = new String[]{"男","女"};
		nationMap = new HashMap<Integer, String>();
		nationMap.put(1, "汉族");
		nationMap.put(2, "苗族");
		nationMap.put(3, "藏族");
		nationMap.put(4, "高山族");
		nationMap.put(5, "朝鲜族");
		nationMap.put(6, "其他民族");
		return SUCCESS;
	}
	public String save() throws Exception{
		System.out.println("nationid="+nationid);
		return null;
	}

	public Map<Integer, String> getNationMap() {
		return nationMap;
	}

	public void setNationMap(Map<Integer, String> nationMap) {
		this.nationMap = nationMap;
	}
}
