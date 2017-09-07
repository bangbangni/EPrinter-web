package ustc.sse.eprint.controller;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;
import ustc.sse.eprint.service.EmployeeLogService;
import ustc.sse.eprint.service.EmployeeService;
import ustc.sse.eprint.util.EprintUtil;

@Controller
public class EmployeeLogin {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EprintUtil eprintUtil;
	@Autowired   
	EmployeeLogService employeeLogService;
	
	@RequestMapping("/employeelogin")
	public String employeelogin(HttpServletRequest request,HttpServletResponse response,Model model ){
		
		String pwd=eprintUtil.toMD5(request.getParameter("password").trim());
		
		Employee employee =  employeeService.getEmployeeByNamePw(request.getParameter("emNumber").trim(),pwd);
		if(employee !=null){
			String ip= eprintUtil.getIpAddress(request);
			/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			String longinTime= df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			*/				
			Timestamp ts = new Timestamp(System.currentTimeMillis());  
			EmployeeLog employeeLog = new EmployeeLog(employee, ip, ts);
			//adminLogService.addAdminLog(adminLog);
			employeeLogService.addEmployeeLog(employeeLog);
			//�����û�
			request.getSession().setAttribute("employee", employee);
			//�����¼ʱ��
			model.addAttribute("loginTime", ts.toString().split(" ")[0]);
			return "userHome";
		}
		return "Login";
	}

}
