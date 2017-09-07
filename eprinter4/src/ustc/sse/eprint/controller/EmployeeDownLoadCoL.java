package ustc.sse.eprint.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.domain.Employee;

@Controller
public class EmployeeDownLoadCoL {

	@RequestMapping("/downloadfile")
	//public String downloadFile(@RequestParam String fileName,HttpServletRequest request,HttpServletResponse response){
	public String downloadFile(HttpServletRequest request,HttpServletResponse response){

		String fileName = request.getParameter("fileName");
		System.out.println(fileName);
		System.out.println(fileName);
		System.out.println(fileName);
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		//String ctxPath = request.getSession().getServletContext().getContextPath("/")+"upload/1"+employee.getEmNumber()+"/";
		String ctxPath;
		if(request.getSession().getAttribute("employee")!=null){
			ctxPath = request.getSession().getServletContext().getRealPath("/")+"upload/"+((Employee)request.getSession().getAttribute("employee")).getEmNumber()+"/";
		}else{
			ctxPath = request.getSession().getServletContext().getRealPath("/")+"upload/publicDoc/";

		}
		String downloadPath=ctxPath + fileName;
		System.out.println(downloadPath);
		
		try{
			long fileLength = new java.io.File(downloadPath).length();
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Length",String.valueOf(fileLength));
			response.setHeader("Content-disposition","attachment;filename="+new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			bis = new BufferedInputStream(new FileInputStream(downloadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff=new byte[2048];
			int bytesRead;
			while((bytesRead = bis.read(buff,0,buff.length-1))!=-1){
				bos.write(buff,0,bytesRead);
			}
		}catch (Exception e){
				
			}finally{
				if(bis !=null){
					try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(bos !=null){
					try {
						bos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return null;
		}
	}
