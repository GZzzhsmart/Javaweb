package com.cn.hnust.dao;
import java.util.List;

import com.cn.hnust.pojo.UserinfoPO;
public interface UserinfoDAO {
	//验证登录
	public UserinfoPO login(UserinfoPO po);
	//查询用户列表
	public List<UserinfoPO> userList(UserinfoPO po);
	//用户新增
	public int addUser(UserinfoPO po);
	//修改用户信息
	public int updateUser(UserinfoPO po);
	 //删除
    public int deleteUser(int userid);
	//查找用户信息的uid
	public List updateUserId(UserinfoPO po);
	//删除用户信息
	public String deleteUser(UserinfoPO po);
}
