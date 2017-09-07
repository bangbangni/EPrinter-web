package ustc.sse.eprint.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;
import ustc.sse.eprint.domain.Files;

@Repository
public interface EmployeeDao {
	
	//ͨ���û�id��ȡ�û�
	public Employee getEmployeeByID(Integer id);
	//ͨ���˺ź������ȡ�û�
	public Employee getEmployeeByNamePw(String emNumber,String password);
	//����û�
	public void addEmployee(Employee employee);
	//�����û���Ϣ
	public void modifyEmployee(Employee employee);
	//��ȡ��Ӧ����ҳ��
	public int getPageCount(int pageSize);
	//��ȡ��Ӧ��ҳÿҳ��ʾ
	public List<Employee> getPageList(int pageSize,int pageNow);


}
