package ustc.sse.eprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/mainLogin")
	public String mainLogin(){
		return "Login";
	}
}
