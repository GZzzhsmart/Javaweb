package com.ht.action;

import java.util.ArrayList;
import java.util.List;

import com.ht.vo.ClassesVo;
import com.ht.vo.NationVo;
import com.ht.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport{

	
	private StudentVo stud;
	private List<NationVo> nationList;
	private List<ClassesVo> classList;
	private String[] hobit;
	public String[] getHobit() {
		return hobit;
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}
	public List<NationVo> getNationList() {
		return nationList;
	}
	public void setNationList(List<NationVo> nationList) {
		this.nationList = nationList;
	}
	public List<ClassesVo> getClassList() {
		return classList;
	}
	public void setClassList(List<ClassesVo> classList) {
		this.classList = classList;
	}
	public StudentVo getStud() {
		return stud;
	}
	public void setStud(StudentVo stud) {
		this.stud = stud;
	}
	public StudentAction() {
		
	}
	
	public String load() throws Exception{
		init();
		return INPUT;
	}
	
	public String add() throws Exception {
		if(stud!=null){
			System.out.println("studid="+stud.getStudid());
			System.out.println("studname="+stud.getStudname());
			System.out.println("age="+stud.getAge());
			System.out.println("sex="+stud.getSex());
			System.out.println("cardno="+stud.getCardno());
			System.out.println("nationid="+stud.getNationid());
			System.out.println("classid="+stud.getClassid());
			String hobit[] = this.hobit;
			for(int i=0;i<hobit.length;i++){
				System.out.println("hobit="+hobit[i]);
			}
		}
		return SUCCESS;
	}
	//ɾ��
	public String del() throws Exception{
		System.out.println("del----");
		return INPUT;
	}
	public void validateDel(){
		if(stud.getStudid()==null || stud.getStudid().equals("")){
			addFieldError("studid", "请输入学号");
		}
		System.out.println("validateDel");
	}
	public void validateAdd(){
		init();
		if(stud==null){
			addFieldError("studid", "ϵͳ请输入学号");
			return;
		}
		if(stud.getStudid()==null || stud.getStudid().equals("")){
			addFieldError("studid", "请输入学号");
		}
		if(stud.getStudname()==null || stud.getStudname().equals("")){
			addFieldError("studname", "请输入姓名");
		}
		if(stud.getAge()<=10 || stud.getAge()>=150){
			addFieldError("age", "年龄必须是1到150之间");
		}
		if(stud.getCardno()==null || stud.getCardno().equals("")){
			addFieldError("cardno", "请输入身份证号");
			return;
		}
		if(stud.getCardno().length()!=18){
			addFieldError("cardno", "身份证号必须为18位");
		}
		if(stud.getSex()==null || stud.getSex().equals("")){
			addFieldError("sex", "请输入性别");
		}
	}
	public void init(){
		nationList = new ArrayList<NationVo>();
		classList = new ArrayList<ClassesVo>();
		ClassesVo c1 = new ClassesVo(1,"宏图1601班");
		ClassesVo c2 = new ClassesVo(2,"宏图1602班");
		ClassesVo c3 = new ClassesVo(3,"宏图1603班");
		ClassesVo c4 = new ClassesVo(4,"宏图1604班");
		classList.add(c1);
		classList.add(c2);
		classList.add(c3);
		classList.add(c4);
		
		NationVo n1 = new NationVo(1,"汉族");
		NationVo n2 = new NationVo(2,"少数民族");
		NationVo n3 = new NationVo(3,"其他民族");
		nationList.add(n1);
		nationList.add(n2);
		nationList.add(n3);
	}
}
