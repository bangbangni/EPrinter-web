package ustc.sse.eprint.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.service.EmployeeService;
import ustc.sse.eprint.util.EprintUtil;

@Controller
public class EmployeeMPwd {

	@Autowired
	EprintUtil eprintUtil;
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/EmployeeModifyPassword")
	public String ModifyPassword(HttpServletRequest request,Map<String,Object> map){
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		/*System.out.println(employee.toString());*/
		String pwd1=eprintUtil.toMD5(request.getParameter("password1").trim());
		String pwd2=eprintUtil.toMD5(request.getParameter("password2").trim());
		String pwd3=eprintUtil.toMD5(request.getParameter("password3").trim());
		if(pwd1.equals(employee.getPassword())){
			if(pwd2!=null)
				if(pwd2.equals(pwd3)){
					employee.setPassword(pwd2);
					employeeService.updateEmployee(employee);
					return "userHome";
				}
		}	
		return "err";
	}
}
