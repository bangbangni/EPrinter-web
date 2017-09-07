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
	        String resource_size = "";
	        DecimalFormat df = new DecimalFormat("#.##");
	        double resourcesize = (double)((double)fis.available()/1024/1024);
	        if(resourcesize>50){
	        	model.addAttribute("error", "�ļ�����50MB");
	        	fis.close(); //�򿪵��ļ��ر�
	        	return "oneUploade";
	        }
	        resource_size =df.format((double)((double)fis.available()/1024/1024))+"MB";
	        employee.setUsedRoom(employee.getUsedRoom()+(double)((double)fis.available()/1024/1024));
	        employeeDao.modifyEmployee(employee);
	        
	        System.out.println("�ĵ���С"+resource_size);
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
		//ֱ����ת����һ��controller�����ܵ�controllerֱ��ӳ��printTransferSet����  ����PrinterChoose
		//return "redirect:/printTransferSet ";
		
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
}
