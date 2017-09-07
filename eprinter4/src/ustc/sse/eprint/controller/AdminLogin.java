package ustc.sse.eprint.controller;

import java.sql.Timestamp;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.domain.Admin;
import ustc.sse.eprint.domain.AdminLog;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;
import ustc.sse.eprint.service.AdminLogService;
import ustc.sse.eprint.service.AdminService;
import ustc.sse.eprint.service.EmployeeLogService;
import ustc.sse.eprint.service.EmployeeService;
import ustc.sse.eprint.util.EprintUtil;

@Controller
public class AdminLogin {
	
	@Autowired
	AdminService adminService;
	@Autowired
	EprintUtil eprintUtil;
	@Autowired
	AdminLogService adminLogService;
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeLogService employeeLogService;
	
	//�û������Ա
	@RequestMapping("/login")
	public String adminLogin(HttpServletRequest request,Model model){
	  if(request.getParameter("selectId").equals("1")){	
		String pwd=eprintUtil.toMD5(request.getParameter("Adpassword").trim());
		
		Admin admin =  adminService.getAdmin(request.getParameter("AdemNumber").trim(),pwd);
		if(admin !=null){
			String ip= eprintUtil.getIpAddress(request);
			/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			String longinTime= df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			*/		
			Timestamp ts = new Timestamp(System.currentTimeMillis());   
			AdminLog adminLog = new AdminLog(admin,ip,ts);
			adminLogService.addAdminLog(adminLog);
			//�����û�
			request.getSession().setAttribute("admin", admin);
			//�����¼ʱ��
			model.addAttribute("loginTime", ts.toString().split(" ")[0]);
			return "adminHome";
		}
		return "Login";
	  }else{
		  String pwd=eprintUtil.toMD5(request.getParameter("Adpassword").trim());
			
			Employee employee =  employeeService.getEmployeeByNamePw(request.getParameter("AdemNumber").trim(),pwd);
			
			if(employee !=null&&employee.getIsBlock()!=1){
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

}
