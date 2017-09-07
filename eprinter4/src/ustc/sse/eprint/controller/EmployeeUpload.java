package ustc.sse.eprint.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.PdfReader;

import ustc.sse.eprint.dao.EmployeeDao;
import ustc.sse.eprint.dao.FileDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.service.FileService;
import ustc.sse.eprint.util.ToPdf;

@Controller
public class EmployeeUpload {

	@Autowired
	public ToPdf toPdf;
	@Autowired
	private FileService fileService;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping("/upload")
	public String oneUpload(@RequestParam("file") MultipartFile imageFile,HttpServletRequest requst,Model model,ModelMap map,HttpServletRequest request) throws UnsupportedEncodingException{
		Employee employee = (Employee) requst.getSession().getAttribute("employee");
		String uploadUrl = requst.getSession().getServletContext().getRealPath("/")+"upload/"+employee.getEmNumber()+"/";
//		System.out.println(uploadUrl);
		String imageName = imageFile.getOriginalFilename();
		
		System.out.println(imageName);
		File dir = new File(uploadUrl);
		if(!dir.exists()){
			dir.mkdirs();
		}
		System.out.println("文件的上传到--"+uploadUrl+imageName);
		//获取文件路径
		File targetFile = new File(uploadUrl+imageName);
		if(!targetFile.exists()){
			try {
				targetFile.createNewFile();							
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//保存文件
		try {
			imageFile.transferTo(targetFile);
			String inputFile=uploadUrl+imageName;		
			String[] a =imageName.split("\\.");
			//防止文件名中有多个"."
			if(a.length >2){
				for(int i=1;i<a.length-1;++i){
					a[0]+=("."+a[i]);
				}
			}
			//计算文件大小
		    FileInputStream fis = new FileInputStream(targetFile);
	        String resource_size = "";
	        DecimalFormat df = new DecimalFormat("#.##");
	        double resourcesize = (double)((double)fis.available()/1024/1024);
	        if(resourcesize>50){
	        	model.addAttribute("error", "文件超过50MB");
	        	fis.close(); //打开的文件关闭
	        	return "oneUploade";
	        }
	        resource_size =df.format((double)((double)fis.available()/1024/1024))+"MB";
	        employee.setUsedRoom(employee.getUsedRoom()+(double)((double)fis.available()/1024/1024));
	        employeeDao.modifyEmployee(employee);
	        
	        System.out.println("文档大小"+resource_size);
	        fis.close(); //打开的文件关闭
	        
			String name= a[0]+".pdf";
			String pdfFile = uploadUrl+name;
			toPdf.convert2PDF(inputFile, pdfFile);
			
			
			int pdfPages;
			try{
			//计算文档页数
				pdfPages = new PdfReader(pdfFile).getNumberOfPages(); //运算加密报异常
			}catch(Throwable e){
				//用这个不行Exception，只能是Throwable了
				System.out.println("加密的异常！！！");
				pdfPages=15;
			}
			//记录文档
			Files file = new Files();
			file.setFileName(imageName);
			file.setFilePages(pdfPages);
			file.setFilePath(uploadUrl+imageName);
			file.setFileSize(resourcesize);
			file.setFileState(0);//打印状态
			file.setFileMark(0);//
			file.setFileType(a[a.length-1]);
			file.setPrinter(null);
			file.setUploadTime(new Timestamp(System.currentTimeMillis()));
			file.setEmployee((Employee) requst.getSession().getAttribute("employee"));
			fileService.addFile(file);
			
			//System.out.println(pdfPages);
			/*requst.getSession().setAttribute("pdfFile", pdfFile);
			System.out.println(requst.getSession().getAttribute("pdfFile"));
			System.out.println(requst.getSession().getAttribute("pdfFile"));
			System.out.println(requst.getSession().getAttribute("pdfFile"));
			requst.getSession().setAttribute("pageNum", pdfPages);
			requst.getSession().setAttribute("file", file);*/
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   /*  String url=null;
	     try {
			url =URLEncoder.encode(imageName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//直接跳转到另一个controller，接受的controller直接映射printTransferSet即可  到了PrinterChoose
		//return "redirect:/printTransferSet ";
		
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Files> files= fileDao.getPageList(employee, 5, pageNow);
		map.addAttribute("files", files);
		map.addAttribute("pageCount", fileDao.getPageCount(5, employee));
		return "EmFileShow";
	}
}
