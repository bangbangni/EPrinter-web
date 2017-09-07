package ustc.sse.eprint.service;

import java.util.Set;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;


public interface EmployeeService {

	//
	public Employee getEmployeeByNamePw(String emNumber, String password);
	//�����û�
	public void updateEmployee(Employee employee);
	//��ȡԱ������־
	public Set<EmployeeLog> getLog(Employee e); 
	//��ȡԱ������һ����־
	public EmployeeLog getLastELog(Employee e);
}
