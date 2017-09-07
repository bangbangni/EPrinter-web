package ustc.sse.eprint.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.dao.AdminDao;
import ustc.sse.eprint.dao.EmployeeDao;
import ustc.sse.eprint.domain.Admin;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.util.EprintUtil;
import ustc.sse.eprint.util.EprintUtilImpl;

@Controller
public class AdminMaPWD {

	EprintUtil eprintUtil = new EprintUtilImpl();
		
	@Autowired
	AdminDao adminDao;
	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping("/modifyAdmin")
	public String toModifyAdmin(){
		return "adModifyAdmin";
	}
	
	//����Ա�Լ�
	@RequestMapping("/confirmModify")
	public String toConModifyAdmin(Model model,HttpServletRequest request){
		
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		String lastPwd = eprintUtil.toMD5(request.getParameter("lastPwd").trim());
		String fristPwd = eprintUtil.toMD5(request.getParameter("fristPwd").trim());
		String secondPwd = eprintUtil.toMD5(request.getParameter("secondPwd").trim());
		if(lastPwd.equals(admin.getPassword())){
			if(fristPwd.equals(secondPwd)){
				admin.setPassword(fristPwd);
				adminDao.modifyAdmin(admin);
				return "adminHome";
			}else{
				model.addAttribute("error", "���β�һ��");
				return "adModifyAdmin";
			}
			
		}else{
			model.addAttribute("error", "��ʼ������󣡣���");
			return "adModifyAdmin";
		}
	}
	
	//�û�����
	@RequestMapping("/userpwManage")
	public String toManagePwd(){
		return "userpwManage";
	}
	@RequestMapping("/adSubmitEmPWD")
	public String toManageEmPwd(HttpServletRequest request,ModelMap map){
		String emId=request.getParameter("emId");
		if(emId!=null){
			Employee employee = employeeDao.getEmployeeByID(Integer.parseInt(emId.trim()));
			if(employee!=null){
			  employee.setPassword("670b14728ad9902aecba32e22fa4f6bd");
			  employeeDao.modifyEmployee(employee);
			  map.addAttribute("succuess", "���óɹ�������");
			}else{
			  map.addAttribute("error1", "Ա����������󣡣���");
			}  
		}else{
			map.addAttribute("error2", "������Ա���ţ�����");
		}
		return "userpwManage";
	}
}
