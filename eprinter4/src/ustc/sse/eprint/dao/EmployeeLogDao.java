package ustc.sse.eprint.dao;

import java.util.List;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;

public interface EmployeeLogDao {

	//添加一条日志
	public void addLog(EmployeeLog log);
	/*//获取员日志
	public List getEmLog(Employee e);
*/}
