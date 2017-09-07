package ustc.sse.eprint.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
@Repository
public interface FileDao {

	//通过文件id获取文档
	public Files getFilesByID(Files file,Integer id);
	//修改文件
	public void modifyFile(Files file);
	//添加文档
	public void addFile(Files file);
	//通过用户获取文档
	public List<Files> getFilesByEmployee(Employee employee);
	//通过文件id删除文档
	public void deleteFileById(Files file,Integer fid);
	//获取对应外键的总的页数
	public int getPageCount(int pageSize,Object ForeignObj);
	//获取对应外键的分页每页显示
	public List<Files> getPageList( Object ForeignObj,int pageSize,int pageNow);
	//模糊搜索文件
	public List<Files> searchPageList( Object ForeignObj,int pageSize,int pageNow,String filename);
	//获取对应外键和文件名的总的页数
	public int searchPageCount(int pageSize,Object ForeignObj,String filename);
	//获取对应外键打印的纸张页数
	public long getAllPages(Object ForeignObj);
	//获取对应年月份打印的纸张页数
	public long getYMPages(Object ForeignObj,String yearMo);
	
	//获取对应外键的总的页数
	public int getPageCount(int pageSize);
	//获取对应外键的分页每页显示
	public List<Files> getPageList(int pageSize,int pageNow);
	
	//模糊搜索文件
	public List<Files> searchPageList(int pageSize,int pageNow,String filename);
	//获取对应外键和文件名的总的页数
	public int searchPageCount(int pageSize,String filename);
}
