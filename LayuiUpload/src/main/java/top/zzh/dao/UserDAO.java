package top.zzh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zzh.vo.UserVo;

/**
 * Created by 曾志湖 on 2017/9/13.
 */
@Repository
public interface UserDAO extends  BaseDAO<UserVo> {
    int checkReg(String acc);
    int checkLogin(String acc);
    void updatePwd(@Param("id") long id, @Param("pwd") String pwd);
    String getPassword(long id);
}
