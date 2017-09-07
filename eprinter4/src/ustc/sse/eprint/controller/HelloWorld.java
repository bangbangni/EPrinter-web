/*package ustc.sse.eprint.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.service.AdminService;
import ustc.sse.eprint.util.EprintUtil;

@Controller
public class HelloWorld {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	EprintUtil eprintUtil;
	

	@RequestMapping(value="/111")
	public String sayHello(ModelMap modelMap,HttpServletRequest request){
		if(adminService.checkAdmin(request.getParameter("id"), request.getParameter("password"))){
			System.out.println(eprintUtil.getIpAddress(request));
			System.out.println(eprintUtil.getIpAddress(request));
			System.out.println(request.getRemoteAddr());
			return "success";
		}
		return "err";
	}
}
*/