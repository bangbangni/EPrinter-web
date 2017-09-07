package ustc.sse.eprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmOperation {

	@RequestMapping()
	public String toFeedBack(){
		return "emFeedBack";
	}
}
