package top.zzh.service;


import top.zzh.vo.UserVo;

/**
 * Created by 曾志湖 on 2017/9/13.
 */
public interface UserService extends BaseService<UserVo> {
    int checkReg(String acc);
    int checkLogin(String acc);
    void updatePwd(long id, String pwd);
    String getPassword(long id);
}
