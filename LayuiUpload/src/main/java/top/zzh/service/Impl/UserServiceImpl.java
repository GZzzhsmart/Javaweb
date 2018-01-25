package top.zzh.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zzh.common.PageQuery;
import top.zzh.common.StatusQuery;
import top.zzh.dao.UserDAO;
import top.zzh.service.UserService;
import top.zzh.vo.UserVo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserVo queryById(long id) {
        return userDAO.queryById(id);
    }

    @Override
    public void update(UserVo userVo) {
        userDAO.update(userVo);
    }

    @Override
    public void add(UserVo userVo) {
        userDAO.add(userVo);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public List<UserVo> pagelist(PageQuery pageQuery) {
        return userDAO.pagelist(pageQuery);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        userDAO.updateStatus(statusQuery);
    }

    @Override
    public int count() {
        return userDAO.count();
    }

    @Override
    public List<UserVo> listAll() {
        return userDAO.listAll();
    }

    @Override
    public int checkReg(String acc) {
        return userDAO.checkReg(acc);
    }

    @Override
    public int checkLogin(String acc) {
        return userDAO.checkReg(acc);
    }

    @Override
    public void updatePwd(long id, String pwd) {
        userDAO.updatePwd(id, pwd);
    }
    @Override
    public String getPassword(long id) {
        return userDAO.getPassword(id);
    }
}
