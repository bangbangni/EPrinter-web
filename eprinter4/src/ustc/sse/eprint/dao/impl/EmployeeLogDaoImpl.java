package ustc.sse.eprint.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.basicdao.BasicDao;
import ustc.sse.eprint.dao.EmployeeLogDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;

@Repository
public class EmployeeLogDaoImpl extends BasicDao implements EmployeeLogDao {

	@Override
	public void addLog(EmployeeLog log) {
		// TODO Auto-generated method stub
		this.add(log);
	}

/*	@Override
	public List getEmLog(Employee e) {
		// TODO Auto-generated method stub
		String hql="from Employee where emNumber=? and password=?" 
		return ;
	}*/

}
