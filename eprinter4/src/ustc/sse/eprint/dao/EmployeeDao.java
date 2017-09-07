package ustc.sse.eprint.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;
import ustc.sse.eprint.domain.Files;

@Repository
public interface EmployeeDao {
	
	//通过用户id获取用户
	public Employee getEmployeeByID(Integer id);
	//通过账号和密码获取用户
	public Employee getEmployeeByNamePw(String emNumber,String password);
	//添加用户
	public void addEmployee(Employee employee);
	//更新用户信息
	public void modifyEmployee(Employee employee);
	//获取对应的总页数
	public int getPageCount(int pageSize);
	//获取对应分页每页显示
	public List<Employee> getPageList(int pageSize,int pageNow);


}
