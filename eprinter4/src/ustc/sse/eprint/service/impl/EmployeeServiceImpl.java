package ustc.sse.eprint.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ustc.sse.eprint.dao.EmployeeDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;
import ustc.sse.eprint.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee getEmployeeByNamePw(String emNumber, String password) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeByNamePw(emNumber, password);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.modifyEmployee(employee);
		
	}

	@Override
	public Set<EmployeeLog> getLog(Employee e) {
		// TODO Auto-generated method stub
		
		return employeeDao.getEmployeeByID(e.getId()).getEmployeeLogs();
	}

	//获取员工日志的倒数第二条
	public EmployeeLog getLastELog(Employee e){
		
		
		Set<EmployeeLog> logs = this.getLog(e);
		if(logs.size()>1){
			List<EmployeeLog> list1 = new ArrayList<EmployeeLog>(logs); 
			Collections.sort(list1);
			return  list1.get(logs.size()-2);
		}else{
			return null;
		}
		
		
	}
	
}
