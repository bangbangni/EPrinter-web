package ustc.sse.eprint.service;

import java.util.Set;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;


public interface EmployeeService {

	//
	public Employee getEmployeeByNamePw(String emNumber, String password);
	//更新用户
	public void updateEmployee(Employee employee);
	//获取员工的日志
	public Set<EmployeeLog> getLog(Employee e); 
	//获取员工的上一条日志
	public EmployeeLog getLastELog(Employee e);
}
