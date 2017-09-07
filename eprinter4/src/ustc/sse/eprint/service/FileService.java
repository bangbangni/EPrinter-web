package ustc.sse.eprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;

@Service
public interface FileService {

	//通过id获取文档
	public Files getFileById(Files file,Integer id);
	//添加文件
	public void addFile(Files file);
	//根据外键获取文件
	public List<Files> getFilesByEm(Employee employee);
	//通过id删除文档
	public void deleteFileById(Files file,Integer id);

}
