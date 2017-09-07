package ustc.sse.eprint.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
@Repository
public interface FileDao {

	//ͨ���ļ�id��ȡ�ĵ�
	public Files getFilesByID(Files file,Integer id);
	//�޸��ļ�
	public void modifyFile(Files file);
	//����ĵ�
	public void addFile(Files file);
	//ͨ���û���ȡ�ĵ�
	public List<Files> getFilesByEmployee(Employee employee);
	//ͨ���ļ�idɾ���ĵ�
	public void deleteFileById(Files file,Integer fid);
	//��ȡ��Ӧ������ܵ�ҳ��
	public int getPageCount(int pageSize,Object ForeignObj);
	//��ȡ��Ӧ����ķ�ҳÿҳ��ʾ
	public List<Files> getPageList( Object ForeignObj,int pageSize,int pageNow);
	//ģ�������ļ�
	public List<Files> searchPageList( Object ForeignObj,int pageSize,int pageNow,String filename);
	//��ȡ��Ӧ������ļ������ܵ�ҳ��
	public int searchPageCount(int pageSize,Object ForeignObj,String filename);
	//��ȡ��Ӧ�����ӡ��ֽ��ҳ��
	public long getAllPages(Object ForeignObj);
	//��ȡ��Ӧ���·ݴ�ӡ��ֽ��ҳ��
	public long getYMPages(Object ForeignObj,String yearMo);
	
	//��ȡ��Ӧ������ܵ�ҳ��
	public int getPageCount(int pageSize);
	//��ȡ��Ӧ����ķ�ҳÿҳ��ʾ
	public List<Files> getPageList(int pageSize,int pageNow);
	
	//ģ�������ļ�
	public List<Files> searchPageList(int pageSize,int pageNow,String filename);
	//��ȡ��Ӧ������ļ������ܵ�ҳ��
	public int searchPageCount(int pageSize,String filename);
}
