package ustc.sse.eprint.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.dao.EmployeeDao;
import ustc.sse.eprint.domain.Employee;


@Controller
public class AdminMaEms {
	
	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/EmDelete")
	public String toMaEm(HttpServletRequest request,ModelMap map){
		String emId = request.getParameter("emId");
		Employee employee = employeeDao.getEmployeeByID(Integer.parseInt(emId));
		if(request.getParameter("block").equals("0")){
			employee.setIsBlock(1);
		}else{
			employee.setIsBlock(0);
		}
	   employeeDao.modifyEmployee(employee);
		
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
	
	//用户空间管理，展示
	@RequestMapping("/adSpcEmMa")
	public String toAdSpcEmMa(ModelMap map,HttpServletRequest request){
		
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Employee> employees= employeeDao.getPageList( 5, pageNow);
		map.addAttribute("employees", employees);
		map.addAttribute("pageCount", employeeDao.getPageCount(5));
		return "adSpcEmMa";
	}
	//用户空间修改
	@RequestMapping("/adAddEmSpc")
	public String toadAddEmSpc(HttpServletRequest request,ModelMap map){
		String emId=request.getParameter("emId");
		Employee employee = employeeDao.getEmployeeByID(Integer.parseInt(emId));
		employee.setEmRoom(employee.getEmRoom()+200);
		employeeDao.modifyEmployee(employee);
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Employee> employees= employeeDao.getPageList( 5, pageNow);
		map.addAttribute("employees", employees);
		map.addAttribute("pageCount", employeeDao.getPageCount(5));
		return "adSpcEmMa";
	}
	@RequestMapping("/adSubEmSpc")
	public String toadSubEmSpc(HttpServletRequest request,ModelMap map){
		String emId=request.getParameter("emId");
		Employee employee = employeeDao.getEmployeeByID(Integer.parseInt(emId));
		if(employee.getEmRoom()>=700)
		{
		 employee.setEmRoom(employee.getEmRoom()-200);
		employeeDao.modifyEmployee(employee);
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Employee> employees= employeeDao.getPageList( 5, pageNow);
		map.addAttribute("employees", employees);
		map.addAttribute("pageCount", employeeDao.getPageCount(5));
		return "adSpcEmMa";
		}else{
			String s_pageNow = request.getParameter("pageNow");
			int pageNow =1;
			if(s_pageNow!=null){
				pageNow = Integer.parseInt(s_pageNow.trim());
			}
			//分页
			List<Employee> employees= employeeDao.getPageList( 5, pageNow);
			map.addAttribute("employees", employees);
			map.addAttribute("pageCount", employeeDao.getPageCount(5));
			map.addAttribute("error","不可在减小");
			return "adSpcEmMa";
		}
	}
}
