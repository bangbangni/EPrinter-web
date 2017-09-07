package ustc.sse.eprint.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.PdfReader;

import ustc.sse.eprint.dao.FileDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.service.EmployeeService;
import ustc.sse.eprint.service.FileService;
import ustc.sse.eprint.util.ToPdf;

@Controller
public class FileManagerCol {

	@Autowired
	EmployeeService emService;
	@Autowired
	FileService fileService;
	@Autowired
	FileDao fileDao;
	
	@RequestMapping("/FileManager")
	//这个toDownLoadFile会跳转到文档的展示界面
	public String toDownLoadFile(ModelMap map,HttpServletRequest request ){
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
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
	
	@RequestMapping("/searchFile")
	public String toSearchFile(ModelMap map,HttpServletRequest request ){
	
		String filename= request.getParameter("emDocName");
		if(filename!=null)
			request.getSession().setAttribute("filename", filename);
		System.out.println("文件名"+filename);
		   Employee employee = (Employee) request.getSession().getAttribute("employee");
		   String s_pageNow = request.getParameter("pageNow");
		   int pageNow =1;
		   if(s_pageNow!=null){
			  pageNow = Integer.parseInt(s_pageNow.trim());
		}
		   //分页
		   List<Files> files= fileDao.searchPageList(employee, 5, pageNow, (String)request.getSession().getAttribute("filename"));
		   map.addAttribute("files", files);
		   map.addAttribute("pageCount", fileDao.searchPageCount(5, employee, (String)request.getSession().getAttribute("filename")));		
		   return "emSearchDoc";		
	}
	
	@RequestMapping("/FileDelete")
	public String toDeleteFile(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		String fileId = request.getParameter("fileId");
		Files file = fileService.getFileById(new Files(),Integer.parseInt(fileId));
		if(file ==null){
			return "err";
		}
		String filePath = file.getFilePath();
		try{
			File fileIo=new File(file.getFilePath());
			fileIo.delete();
		}catch(Exception e){
			
			e.printStackTrace();
		}
		//顺带把pdf也删了
		try{
			String[] a =filePath.split("\\.");
			//防止文件名中有多个"."
			if(!a[a.length-1].equals("pdf")){
			if(a.length >2){
				for(int i=1;i<a.length-1;++i){
					a[0]+=("."+a[i]);
				}
			}
			a[0]+=".pdf";
				File fileIo=new File(a[0]);
				fileIo.delete();
			}		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		fileService.deleteFileById(new Files(), Integer.parseInt(fileId));
		
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		if(employee!=null){
		//分页
		List<Files> files= fileDao.getPageList(employee, 5, pageNow);
		map.addAttribute("files", files);
		map.addAttribute("pageCount", fileDao.getPageCount(5, employee));
		   return "EmFileShow";
		}else{
			List<Files> files= fileDao.getPageList(5, pageNow);
			map.addAttribute("files", files);
			map.addAttribute("pageCount", fileDao.getPageCount(5));
			return "admPublicDocmentMa";
		}
	}
	
	
	//管理员公共文档的展示
	@RequestMapping("/admPublicDocmentMa")
	public String toadPubDocMa(ModelMap map,HttpServletRequest request ){
		
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Files> files= fileDao.getPageList(5, pageNow);
		map.addAttribute("files", files);
		map.addAttribute("pageCount", fileDao.getPageCount(5));
		
		return "admPublicDocmentMa";
	}
	
	@Autowired
	public ToPdf toPdf;	
	//管理员公共文档上传
	@RequestMapping("/upDocPub")
	public String oneUpload(@RequestParam("file") MultipartFile imageFile,HttpServletRequest requst,ModelMap model) throws UnsupportedEncodingException{
		String uploadUrl = requst.getSession().getServletContext().getRealPath("/")+"upload/publicDoc/";

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
	        double resourcesize = (double)((double)fis.available()/1024/1024);
	        if(resourcesize>50){
	        	model.addAttribute("error", "文件超过50MB");
	        	fis.close(); //打开的文件关闭  
	        	String s_pageNow = requst.getParameter("pageNow");
	    		int pageNow =1;
	    		if(s_pageNow!=null){
	    			pageNow = Integer.parseInt(s_pageNow.trim());
	    		}
	    		//分页
	    		List<Files> files= fileDao.getPageList(5, pageNow);
	    		model.addAttribute("files", files);
	    		model.addAttribute("pageCount", fileDao.getPageCount(5));
	        	return "admPublicDocmentMa";
	        }
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
			file.setFileMark(1);//
			file.setFileType(a[a.length-1]);
			file.setPrinter(null);
			file.setUploadTime(new Timestamp(System.currentTimeMillis()));
			file.setEmployee(null);
			fileService.addFile(file);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s_pageNow = requst.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Files> files= fileDao.getPageList(5, pageNow);
		model.addAttribute("files", files);
		model.addAttribute("pageCount", fileDao.getPageCount(5));
		
		return "admPublicDocmentMa";
		
	}
	
	//用户公共文档
	@RequestMapping("/EmPublicDoc")
	public String toEmPubDocDisplay(ModelMap map,HttpServletRequest request){
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//分页
		List<Files> files= fileDao.getPageList(5, pageNow);
		map.addAttribute("files", files);
		map.addAttribute("pageCount", fileDao.getPageCount(5));
		
		return "EmPublicDocList";
	}
	//用户搜索公共文档
	@RequestMapping("/searchPublicFile")
	public String toEmSearchPubDoc(HttpServletRequest request,ModelMap map){
		String filename= request.getParameter("emDocName");
		if(filename!=null)
			request.getSession().setAttribute("filename", filename);
		System.out.println("文件名"+filename);
		   Employee employee = (Employee) request.getSession().getAttribute("employee");
		   String s_pageNow = request.getParameter("pageNow");
		   int pageNow =1;
		   if(s_pageNow!=null){
			  pageNow = Integer.parseInt(s_pageNow.trim());
		}
		   //分页
		   List<Files> files= fileDao.searchPageList(employee, 5, pageNow, (String)request.getSession().getAttribute("filename"));
		   map.addAttribute("files", files);
		   map.addAttribute("pageCount", fileDao.searchPageCount(5, employee, (String)request.getSession().getAttribute("filename")));		
		   return "emSearchPublicDoc";
	}
	
	
	
	//返回首页
	@RequestMapping("/userHome")
	public String toHome(){
		return "userHome";
	}
	
}
