package ustc.sse.eprint.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.dao.EmployeeDao;
import ustc.sse.eprint.dao.FileDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.service.AdminService;

@Controller
public class ToManagerAdmin {
	@Autowired
	AdminService adminService;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	FileDao fileDao;
	
	@RequestMapping("/adminManger")
	public String toAdminManager(ModelMap map,HttpServletRequest request){
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Employee> employees= employeeDao.getPageList( 5, pageNow);
		map.addAttribute("employees", employees);
		map.addAttribute("pageCount", employeeDao.getPageCount(5));
		return "adminManger";
	}
	
	//用户的管理
	@RequestMapping("/adminAddEm")
	public String toadminAddEm(ModelMap map,HttpServletRequest request){
		
		
		return "adminAddEm";
	}
	
	//添加用户
	@RequestMapping("/addEm")
	public String addEm(HttpServletRequest request,HttpServletResponse response,ModelMap map){
		
		
		String name= request.getParameter("name");
		String emId=request.getParameter("emId");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		
		Employee employee = new Employee();
		employee.setCreteTime(new Timestamp(System.currentTimeMillis()));
		employee.setEmail(email);
		employee.setEmName(name);
		employee.setEmNumber(emId);
		employee.setTeleNumber(tel);
		employee.setPassword("670b14728ad9902aecba32e22fa4f6bd");
		employee.setRole(0);
		employee.setIsBlock(0);
		employee.setEmRoom(500.0);
		employee.setUsedRoom(0.0);
		
		employeeDao.addEmployee(employee);

		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Employee> employees= employeeDao.getPageList( 5, pageNow);
		map.addAttribute("employees", employees);
		map.addAttribute("pageCount", employeeDao.getPageCount(5));
		return "adminManger";
	}
	
	//查看员工的日志信息(返回打印的纸张数)
	@RequestMapping("/mangerEmLog")
	public String tomangerEmLog(ModelMap map, HttpServletRequest request,HttpServletResponse response){
		
		String emId = request.getParameter("emId");
		Employee employee = employeeDao.getEmployeeByID(Integer.parseInt(emId));
		long filePages=0;
		if(employee !=null){
			filePages = fileDao.getAllPages(employee);
		}
		List<Integer> moth = new ArrayList<Integer>();
		
		
		for(int i=1;i<=12;++i){
			moth.add((int) fileDao.getYMPages(employee, "2016-"+i));
		}
		
		map.addAttribute("pages", filePages);
		map.addAttribute("em", employee);
		map.addAttribute("YMpages", moth);
		
		return "adManagerEmLog";
	}
	//返回管理员首页
	@RequestMapping("/adminHome")
	public String toAdminHome(){
		return "adminHome";
	}
	
	//退出管理界面
	@RequestMapping("/goOut")
	public String toLogin(HttpServletRequest request){
		request.getSession().invalidate();
		return "Login";
	}
	
}
