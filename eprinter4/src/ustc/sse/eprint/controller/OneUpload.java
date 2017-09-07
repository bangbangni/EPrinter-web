/*package ustc.sse.eprint.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ustc.sse.eprint.util.ToPdf;

@Controller
public class OneUpload {

	@Autowired
    public ToPdf toPdf;
	

	@RequestMapping("/upload")
	public String oneUpload(@RequestParam("file") MultipartFile imageFile,HttpServletRequest requst){
		String uploadUrl = requst.getSession().getServletContext().getRealPath("/")+"upload\\";
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
			String name= a[0]+".pdf";
			String pdfFile = uploadUrl+name;
			toPdf.convert2PDF(inputFile, pdfFile);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     String url=null;
	     try {
			url =URLEncoder.encode(imageName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:http://localhost:8080/eprinter/upload/"+url;
		
	}
}
*/

/*import java.io.File;  
import java.util.Date;  
  
import javax.servlet.http.HttpServletRequest;  
  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.multipart.MultipartFile;  
  
@Controller  
public class UploadAction {  
  
    @RequestMapping(value = "/upload.do")  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
  
        System.out.println("开始");  
        System.out.println(file.getOriginalFilename());
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path); 
        System.out.println(request.getContextPath()+"/upload/"+fileName);
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileName", fileName);
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
  
        return "result";  
    }  
  
}  */