package ustc.sse.eprint.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.dao.FileDao;
import ustc.sse.eprint.dao.PrinterDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.domain.Printer;
import ustc.sse.eprint.util.MinaFileClient;
import ustc.sse.eprint.util.ToPrint;

@Controller
public class PrinterChoose {
	
	@Autowired
	PrinterDao printerDao;
	@Autowired
	FileDao fileDao;
	@Autowired
	ToPrint toPrint;
	
	
	@RequestMapping("/printTransferSet")
	public String printerCol(Model model,HttpServletRequest requst){
		String fileId = requst.getParameter("fileId");
		Files file = fileDao.getFilesByID(new Files(), Integer.parseInt(fileId));
		String[] a =file.getFilePath().split("\\.");
		//防止文件名中有多个"."
		if(a.length >2){
			for(int i=1;i<a.length-1;++i){
				a[0]+=("."+a[i]);
			}
		}
		requst.getSession().setAttribute("pdfFilePath", a[0]+".pdf");
		System.out.println(a[0]+".pdf");
		System.out.println(a[0]+".pdf");
		System.out.println(a[0]+".pdf");
		requst.getSession().setAttribute("pageNum", file.getFilePages());
		requst.getSession().setAttribute("file", file);
		model.addAttribute("printers",printerDao.getOpenPrinters());
		return "printSet";
	}
	//打印文档
	@RequestMapping("/printFilePdf")
	public String printPdf(HttpServletRequest request,ModelMap map ){
		String printerId = request.getParameter("printId");
		Printer printer = printerDao.getPrinterByID(new Printer(), Integer.parseInt(printerId));
		String pageSize=request.getParameter("pageSizes");//页面尺寸
		
		String[] iPort = printer.getPriIp().split(":");
		String filePath = (String) request.getSession().getAttribute("pdfFilePath");
		File file1= new File(filePath);
		
		System.out.println(file1.exists());
		System.out.println(file1.exists());
		System.out.println(file1.exists());
		Integer pageNum = (Integer) request.getSession().getAttribute("pageNum");
		
/*		System.out.println(pageNum);
		System.out.println(pageNum);
		System.out.println(pageNum);*/
		/*sendMessage  sendMessage= new sendMessage(filePath);
		sendMessage.createClienStream(iPort[0], Integer.parseInt(iPort[1]));*/
		MinaFileClient minaFileClient = new MinaFileClient(Integer.parseInt(iPort[1]), iPort[0], filePath);
		minaFileClient.createClienStream(minaFileClient); 
		
		
		Files file= (Files)request.getSession().getAttribute("file");
		file.setFileState(1);
		fileDao.modifyFile(file);
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		//分页
		List<Files> files= fileDao.getPageList(employee, 5, pageNow);
		map.addAttribute("files", files);
		map.addAttribute("pageCount", fileDao.getPageCount(5, employee));
		return "EmFileShow";
	}

}
