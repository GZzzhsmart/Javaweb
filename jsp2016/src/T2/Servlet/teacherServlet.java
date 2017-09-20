package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import base.AesUtils;
import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.ManagerVo;
import bean.PageObject1;
import bean.TeacherVo;

public class teacherServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("list")){
			//��ѯ���е���ݲ�ת���б�ҳ��
			listPage(request, response);
			//�ض���teacherList.jspҳ��
			request.getRequestDispatcher("/T11/teacherList.jsp").forward(request, response);
		}else if(action.equals("add")){
			TeacherVo teacher = new TeacherVo();
			teacher.setTeacherMobile(request.getParameter("teacherMobile").trim());
			String pwd = request.getParameter("teacherPassword").trim();
			//��������м��ܴ���
			pwd = AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			teacher.setTeacherPassword(pwd);
			teacher.setTeacherName(request.getParameter("teacherName").trim());
			teacher.setSex(Integer.parseInt(request.getParameter("sex")));
			teacher.setHomeAddress(request.getParameter("homeAddress").trim());
			teacher.setEmail(request.getParameter("email").trim());
			teacher.setTeacherIntroduce(request.getParameter("teacherIntroduce").trim());
			teacher.setTeacherSpecial(request.getParameter("teacherSpecial").trim());
			teacher.setTeacherLength(request.getParameter("teacherLength").trim());
			teacher.setEducation(request.getParameter("education").trim());
			teacher.setHeadpictureUrl(request.getParameter("headpictureUrl").trim());
			teacher.setBankId(Integer.parseInt(request.getParameter("bankId")));
			teacher.setAccountNo(request.getParameter("accountNo").trim());
			teacher.setAccountName(request.getParameter("accountName").trim());
			teacher.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
			base.teacherAdd(teacher);
			listPage(request, response);
			request.getRequestDispatcher("/T11/teacherList.jsp").forward(request,response);
		}else if(action.equals("del")){
			String teacherId = request.getParameter("teacherId");
			base.teacherDel(Integer.parseInt("teacherId"));
			listPage(request, response);
			request.getRequestDispatcher("/T11/teacherList.jsp").forward(request,response);
		}else if(action.equals("update")){
			String teacherId = request.getParameter("teacherId");
			TeacherVo teacher = base.findteacherById(teacherId);
			request.setAttribute("teacher", teacher);
			listPage(request, response);
			request.getRequestDispatcher("/T11/teacherUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			String teacherMobile = request.getParameter("teacherMobile");
			String teacherName = request.getParameter("teacherName");
			String homeAddress = request.getParameter("homeAddress");
			String email = request.getParameter("email");
			String teacherIntroduce = request.getParameter("teacherIntroduce");
			String teacherSpecial = request.getParameter("teacherSpecial");
			String teacherLength = request.getParameter("teacherLength");
			String education = request.getParameter("education");
			String headpictureUrl = request.getParameter("headpictureUrl");
			String accountNo = request.getParameter("accountNo");
			String accountName = request.getParameter("accountName");
			TeacherVo teacher = new TeacherVo();
			teacher.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
			teacher.setTeacherMobile(teacherMobile);
			teacher.setTeacherName(teacherName);
			teacher.setSex(Integer.parseInt(request.getParameter("sex")));
			teacher.setHomeAddress(homeAddress);
			teacher.setEmail(email);
			teacher.setTeacherIntroduce(teacherIntroduce);
			teacher.setTeacherSpecial(teacherSpecial);
			teacher.setTeacherLength(teacherLength);
			teacher.setEducation(education);
			teacher.setHeadpictureUrl(headpictureUrl);
			teacher.setBankId(Integer.parseInt(request.getParameter("bankId")));
			teacher.setAccountNo(accountNo);
			teacher.setAccountName(accountName);
			teacher.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
			base.teacherUpdate(teacher);
			listPage(request, response);
			request.getRequestDispatcher("/T11/teacherList.jsp").forward(request,response);
		}else if(action.equals("modifypwd2")){
			String teacherId = request.getParameter("teacherId");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String newPassword = AesUtils.encryptStr(request.getParameter("newPassword"),AesUtils.SECRETKEY);
			if(base.checkPwd(teacherId, oldpwd)){
				//�޸�����
				base.modifypwd1(teacherId, newPassword);
				//��modifyPwd.jspҳ��ȡֵ
				request.setAttribute("msg", "��ϲ�㣬�����޸ĳɹ��������Ʊ���");
			}else{
				request.setAttribute("msg", "�����������������������");
			}
			//ת��
			request.getRequestDispatcher("/T11/modifypwd2.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			//��ʼ������
			String teacherId = request.getParameter("teacherId");
			base.modifyPwd(teacherId, AesUtils.encryptStr("8888", AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","��ʼ������ɹ�����ʼ����Ϊ��8888");
			request.getRequestDispatcher("/T11/teacherList.jsp").forward(request, response);
		}
	}

	//��ѯ���еĽ�ʦ���
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡ��ݿ��еĽ�ʦ���
		List<TeacherVo> teacherList = base.teacherList();
		//����request����������������еĽ�ʦ���
		request.setAttribute("teacherList", teacherList);
	}
	//��ҳ��ʾ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from teacher");
		PageObject1 pager = new PageObject1();
		//���õ�һ������
		pager.setRecordCount(cnt);
		//���õڶ�������
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//���õ��������
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//��ȡ��ǰҳ
		int currPage = pager.getCurrentPage();
		//��ȡ��ݿ������еĽ�ʦ���
		List<TeacherVo> teacherList = base.findteacherByPage(pager.getPageSize(),pager.getStartPos());
		//����request����������������ԵĽ�ʦ���
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("pager", pager);
	}

}
