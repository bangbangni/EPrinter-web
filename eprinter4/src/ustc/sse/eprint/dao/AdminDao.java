package ustc.sse.eprint.dao;

import ustc.sse.eprint.domain.Admin;
import ustc.sse.eprint.domain.Employee;

public interface AdminDao {
	
	//ͨ������Աid���ù��Ż�ȡ����Ա
	public Admin getAdminById(java.io.Serializable id);
	
	//ͨ���˺ź������ȡ�û�
	public Admin getAdminByNamePw(String id,String name);
	//���¹���Ա��Ϣ
	public void modifyAdmin(Admin admin);

}
