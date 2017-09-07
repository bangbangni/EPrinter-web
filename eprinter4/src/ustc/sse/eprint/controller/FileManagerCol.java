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
	//���toDownLoadFile����ת���ĵ���չʾ����
	public String toDownLoadFile(ModelMap map,HttpServletRequest request ){
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//��ҳ
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
		System.out.println("�ļ���"+filename);
		   Employee employee = (Employee) request.getSession().getAttribute("employee");
		   String s_pageNow = request.getParameter("pageNow");
		   int pageNow =1;
		   if(s_pageNow!=null){
			  pageNow = Integer.parseInt(s_pageNow.trim());
		}
		   //��ҳ
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
		//˳����pdfҲɾ��
		try{
			String[] a =filePath.split("\\.");
			//��ֹ�ļ������ж��"."
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
		//��ҳ
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
	
	
	//����Ա�����ĵ���չʾ
	@RequestMapping("/admPublicDocmentMa")
	public String toadPubDocMa(ModelMap map,HttpServletRequest request ){
		
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//��ҳ
		List<Files> files= fileDao.getPageList(5, pageNow);
		map.addAttribute("files", files);
		map.addAttribute("pageCount", fileDao.getPageCount(5));
		
		return "admPublicDocmentMa";
	}
	
	@Autowired
	public ToPdf toPdf;	
	//����Ա�����ĵ��ϴ�
	@RequestMapping("/upDocPub")
	public String oneUpload(@RequestParam("file") MultipartFile imageFile,HttpServletRequest requst,ModelMap model) throws UnsupportedEncodingException{
		String uploadUrl = requst.getSession().getServletContext().getRealPath("/")+"upload/publicDoc/";

		String imageName = imageFile.getOriginalFilename();
		
		System.out.println(imageName);
		File dir = new File(uploadUrl);
		if(!dir.exists()){
			dir.mkdirs();
		}
		System.out.println("�ļ����ϴ���--"+uploadUrl+imageName);
		//��ȡ�ļ�·��
		File targetFile = new File(uploadUrl+imageName);
		if(!targetFile.exists()){
			try {
				targetFile.createNewFile();							
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�����ļ�
		try {
			imageFile.transferTo(targetFile);
			String inputFile=uploadUrl+imageName;		
			String[] a =imageName.split("\\.");
			//��ֹ�ļ������ж��"."
			if(a.length >2){
				for(int i=1;i<a.length-1;++i){
					a[0]+=("."+a[i]);
				}
			}
			//�����ļ���С
		    FileInputStream fis = new FileInputStream(targetFile);	     
	        double resourcesize = (double)((double)fis.available()/1024/1024);
	        if(resourcesize>50){
	        	model.addAttribute("error", "�ļ�����50MB");
	        	fis.close(); //�򿪵��ļ��ر�  
	        	String s_pageNow = requst.getParameter("pageNow");
	    		int pageNow =1;
	    		if(s_pageNow!=null){
	    			pageNow = Integer.parseInt(s_pageNow.trim());
	    		}
	    		//��ҳ
	    		List<Files> files= fileDao.getPageList(5, pageNow);
	    		model.addAttribute("files", files);
	    		model.addAttribute("pageCount", fileDao.getPageCount(5));
	        	return "admPublicDocmentMa";
	        }
	        fis.close(); //�򿪵��ļ��ر�  
			String name= a[0]+".pdf";
			String pdfFile = uploadUrl+name;
			toPdf.convert2PDF(inputFile, pdfFile);
		
			int pdfPages;
			try{
			//�����ĵ�ҳ��
				pdfPages = new PdfReader(pdfFile).getNumberOfPages(); //������ܱ��쳣
			}catch(Throwable e){
				//���������Exception��ֻ����Throwable��
				System.out.println("���ܵ��쳣������");
				pdfPages=15;
			}
			//��¼�ĵ�
			Files file = new Files();
			file.setFileName(imageName);
			file.setFilePages(pdfPages);
			file.setFilePath(uploadUrl+imageName);
			file.setFileSize(resourcesize);
			file.setFileState(0);//��ӡ״̬
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
		//��ҳ
		List<Files> files= fileDao.getPageList(5, pageNow);
		model.addAttribute("files", files);
		model.addAttribute("pageCount", fileDao.getPageCount(5));
		
		return "admPublicDocmentMa";
		
	}
	
	//�û������ĵ�
	@RequestMapping("/EmPublicDoc")
	public String toEmPubDocDisplay(ModelMap map,HttpServletRequest request){
		String s_pageNow = request.getParameter("pageNow");
		int pageNow =1;
		if(s_pageNow!=null){
			pageNow = Integer.parseInt(s_pageNow.trim());
		}
		//��ҳ
		List<Files> files= fileDao.getPageList(5, pageNow);
		map.addAttribute("files", files);
		map.addAttribute("pageCount", fileDao.getPageCount(5));
		
		return "EmPublicDocList";
	}
	//�û����������ĵ�
	@RequestMapping("/searchPublicFile")
	public String toEmSearchPubDoc(HttpServletRequest request,ModelMap map){
		String filename= request.getParameter("emDocName");
		if(filename!=null)
			request.getSession().setAttribute("filename", filename);
		System.out.println("�ļ���"+filename);
		   Employee employee = (Employee) request.getSession().getAttribute("employee");
		   String s_pageNow = request.getParameter("pageNow");
		   int pageNow =1;
		   if(s_pageNow!=null){
			  pageNow = Integer.parseInt(s_pageNow.trim());
		}
		   //��ҳ
		   List<Files> files= fileDao.searchPageList(employee, 5, pageNow, (String)request.getSession().getAttribute("filename"));
		   map.addAttribute("files", files);
		   map.addAttribute("pageCount", fileDao.searchPageCount(5, employee, (String)request.getSession().getAttribute("filename")));		
		   return "emSearchPublicDoc";
	}
	
	
	
	//������ҳ
	@RequestMapping("/userHome")
	public String toHome(){
		return "userHome";
	}
	
}
