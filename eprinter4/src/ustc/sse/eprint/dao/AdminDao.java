package ustc.sse.eprint.dao;

import ustc.sse.eprint.domain.Admin;
import ustc.sse.eprint.domain.Employee;

public interface AdminDao {
	
	//通过管理员id或用工号获取管理员
	public Admin getAdminById(java.io.Serializable id);
	
	//通过账号和密码获取用户
	public Admin getAdminByNamePw(String id,String name);
	//更新管理员信息
	public void modifyAdmin(Admin admin);

}
