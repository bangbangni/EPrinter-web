package ustc.sse.eprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ustc.sse.eprint.dao.AdminDao;
import ustc.sse.eprint.dao.EmployeeDao;
import ustc.sse.eprint.domain.Admin;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.service.AdminService;
import ustc.sse.eprint.service.EmployeeService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	@Autowired
	EmployeeDao employeeDao;


	@Override
	public Admin getAdmin(String id, String password) {

		return adminDao.getAdminByNamePw(id, password);
	}

}
