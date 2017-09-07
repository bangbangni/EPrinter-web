package ustc.sse.eprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ustc.sse.eprint.dao.EmployeeLogDao;
import ustc.sse.eprint.domain.EmployeeLog;
import ustc.sse.eprint.service.EmployeeLogService;

@Service
public class EmployeeLogServiceImpl implements EmployeeLogService {

	@Autowired
	EmployeeLogDao employeeLogDao;
	@Override
	public void addEmployeeLog(EmployeeLog employeeLog) {
		// TODO Auto-generated method stub
		employeeLogDao.addLog(employeeLog);
		
	}

}
