package ustc.sse.eprint.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.dao.PrinterDao;
import ustc.sse.eprint.domain.Printer;

@Controller
public class AdminMaPrinters {

	@Autowired
	PrinterDao printerDao;
	
	@RequestMapping("/adminPrinterMa")
	public String toAdminPrinterMa(ModelMap map,HttpServletRequest request){
		
		String pageNowStr = request.getParameter("pageNow");
		int pageNow;
		if(pageNowStr==null){
			pageNow=1;
		}else{
			pageNow = Integer.parseInt(pageNowStr);
		}
		List<Printer> printers = printerDao.getPageList(5, pageNow);
		int pages = printerDao.getPageCount(5);
		map.addAttribute("printers", printers);
		map.addAttribute("pages", pages);
		return "adminPrinterMa";
	}
	
	@RequestMapping("/adminAddPrinter")
	public String toAdminAddPrinter(){
		return "adminAddPrinter";
	}
	
	@RequestMapping("/AddPrinter")
	public String toAddPrinter(ModelMap map,HttpServletRequest request){
		Printer printer = new Printer();
		printer.setPriIp(request.getParameter("priIp"));
		printer.setPriLocal(request.getParameter("priLocal"));
		printer.setPriName(request.getParameter("priName"));
		printer.setPriNumber(request.getParameter("priNumber"));
		printer.setPriState(1);
		
		printerDao.addPrinter(printer);
		
		String pageNowStr = request.getParameter("pageNow");
		int pageNow;
		if(pageNowStr==null){
			pageNow=1;
		}else{
			pageNow = Integer.parseInt(pageNowStr);
		}
		List<Printer> printers = printerDao.getPageList(5, pageNow);
		int pages = printerDao.getPageCount(5);
		map.addAttribute("printers", printers);
		map.addAttribute("pages", pages);
		return "adminPrinterMa";
	}
	
	@RequestMapping("/displayPrinter")
	public String toDisplayPrinter(HttpServletRequest request,ModelMap map){
		String prinId=request.getParameter("priId");
		Printer printer = printerDao.getPrinterByID(new Printer(), Integer.parseInt(prinId));
		map.addAttribute("printer", printer);
		
		return "admodifyDisplayPrinter";
	}
	
	@RequestMapping("/admodifyPrinter")
	public String toAdModifyPrinter(HttpServletRequest request,ModelMap map){
	   String priId = request.getParameter("priId");
	   Printer printer = printerDao.getPrinterByID(new Printer(), Integer.parseInt(priId));
	   	printer.setPriIp(request.getParameter("priIp"));
		printer.setPriLocal(request.getParameter("priLocal"));
		printer.setPriName(request.getParameter("priName"));
		printer.setPriNumber(request.getParameter("priNumber"));
		if(request.getParameter("priState").trim().equals("true")){
			printer.setPriState(0);
		}else{
			printer.setPriState(1);
		}
		printerDao.modifyPrinter(printer);
		
		String pageNowStr = request.getParameter("pageNow");
		int pageNow;
		if(pageNowStr==null){
			pageNow=1;
		}else{
			pageNow = Integer.parseInt(pageNowStr);
		}
		List<Printer> printers = printerDao.getPageList(5, pageNow);
		int pages = printerDao.getPageCount(5);
		map.addAttribute("printers", printers);
		map.addAttribute("pages", pages);
		return "adminPrinterMa";
	   
	}
	
}
