package ustc.sse.eprint.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.service.EmployeeService;

@Controller
public class ToManagerUser {

	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/userManager")
	public String toUserManager(HttpServletRequest request,Map<String,Object> map){
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		map.put("Allnumber", employeeService.getLog(employee).size());
		if(employeeService.getLastELog(employee)!=null){
			map.put("lastIp", employeeService.getLastELog(employee).getIp());
			map.put("lastTime", employeeService.getLastELog(employee).getLonginTime().toString());
		}else{
			map.put("lastIp","第一次");
			map.put("lastTime","第一次");
		}
		return "userManager";
	}
	
	@RequestMapping("/Printdocument")
	public String toPrintdocument(){
		return "printDocument";
	}
	
}
