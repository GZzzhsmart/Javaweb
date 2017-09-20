package com.cn.hnust.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.dao.UserinfoDAO;
import com.cn.hnust.pojo.UserinfoPO;
import com.cn.hnust.service.UserInfoInterface;
@Service
public class UserInfoImpl implements UserInfoInterface{
	@Resource //自动装载，根据名称注入
	private UserinfoDAO userDao;
	
	public UserinfoPO getlogin(UserinfoPO po) {
		// TODO Auto-generated method stub
		UserinfoPO userinfo=userDao.login(po);
		return userinfo;
	}
	/**
	 * 查询用户列表
	 */
	public List<UserinfoPO> getuserList(UserinfoPO userinfoPO) {
		List<UserinfoPO> userlist=userDao.userList(userinfoPO);
		return userlist;
	}
	
	public String getaddUser(UserinfoPO po) {
		// TODO Auto-generated method stub
		int i=userDao.addUser(po);
		String message="";
		if(i>0){
			message="添加成功";
		}else{
			message="添加失败";
		}
		return message;
	}
	public String getUpdateUser(UserinfoPO po) {
		// TODO Auto-generated method stub
		int i=userDao.updateUser(po);
		String message="";
		if(i>0){
			message="修改成功";
		}else{
			message="修改失败";
		}
		return message;
	}
	@RequestMapping("/uid")
	public List<UserinfoPO> getUserById(UserinfoPO po) {
		List<UserinfoPO> updateid=userDao.updateUserId(po);
		return updateid;
	}
	@Override
	public int getDeleteUser(int userid) {
		return userDao.deleteUser(userid);
	}
	
	

}
