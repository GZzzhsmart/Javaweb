package T15;

import java.util.List;
import java.util.Vector;

public interface IUserDAO {
	public void add(UserVo user);
	public void update(UserVo user);
	public void delete(UserVo user);
	public List<UserVo> find();
	Vector find(String userName, String sex, String qqCode);
	public boolean isExists(String userName);
}
