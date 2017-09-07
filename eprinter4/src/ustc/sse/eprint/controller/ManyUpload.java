package ustc.sse.eprint.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ManyUpload {
	@RequestMapping("/manyupload")
	public String manyUpload(HttpServletRequest request){
		
		//转换为MultipartHttpServletRequest，获取多个文件的请求
		MultipartHttpServletRequest request2 = (MultipartHttpServletRequest)request;
		//MultipartHttpServletRequest中的getFileMap方法，获取相应的Map
		Map<String,MultipartFile> files=request2.getFileMap();
		
		//request.getSession().getServletContext().getRealPath("/"):D:\apache-tomcat\webapps\eprinter\
		//获取到在服务器中的相对路径
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		//存放的路径
		String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"upload\\";
		File dir = new File(uploadUrl);
		if(!dir.exists()){
			dir.mkdirs();
		}
		List<String> fileList = new ArrayList<>();
		for(MultipartFile file : files.values()){
			File targetFile = new File(uploadUrl+file.getOriginalFilename());
			if(!targetFile.exists()){
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				//MultipartFile中的transferTo方法直接保存到相应的文件：文件夹+要保存的文件名
				file.transferTo(targetFile);
				String url=URLEncoder.encode(file.getOriginalFilename(),"UTF-8");
				fileList.add("http://localhost:8080/eprinter/upload/"+url);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("files", fileList);
		return "manyUploadRuselt";
	}
}
