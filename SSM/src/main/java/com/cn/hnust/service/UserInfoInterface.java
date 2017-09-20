package com.cn.hnust.service;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.cn.hnust.pojo.UserinfoPO;
public interface UserInfoInterface {
	//登录验证
	public UserinfoPO getlogin(UserinfoPO po);
	public List<UserinfoPO> getuserList(UserinfoPO userinfoPO);
	public String getaddUser(UserinfoPO po);
	public String getUpdateUser(UserinfoPO po);
	public int  getDeleteUser(int userid);
	//查找用户通过Id
	public List<UserinfoPO> getUserById(UserinfoPO po);
}
