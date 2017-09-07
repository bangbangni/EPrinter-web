package ustc.sse.eprint.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.basicdao.BasicDao;
import ustc.sse.eprint.dao.EmployeeDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;

@Repository
public class EmployeeDaoImpl extends BasicDao implements EmployeeDao {

	@Override
	public Employee getEmployeeByNamePw(String emNumber, String password) {
		// TODO Auto-generated method stub
		String hql="from Employee where emNumber=? and password=?";
		String[] parameters={emNumber,password};
		Employee employee = (Employee)  this.executeQueryUnique(hql, parameters);
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.add(employee);
	}

	@Override
	public void modifyEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.update(employee);
		
	}
	@Override
	public Employee getEmployeeByID(Integer id) {
		// TODO Auto-generated method stub
		String hql="from Employee where id=?";
		Object[] parameters={id};
		Employee employee = (Employee)  this.executeQueryUnique(hql, parameters);
		return employee;
	}

	@Override
	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Employee";
		return this.queryPageCount(hql,null, pageSize);
	}

	@Override
	public List<Employee> getPageList(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Employee c order by c.id desc ";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

}
