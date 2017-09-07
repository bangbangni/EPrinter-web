package ustc.sse.eprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;

@Service
public interface FileService {

	//ͨ��id��ȡ�ĵ�
	public Files getFileById(Files file,Integer id);
	//����ļ�
	public void addFile(Files file);
	//���������ȡ�ļ�
	public List<Files> getFilesByEm(Employee employee);
	//ͨ��idɾ���ĵ�
	public void deleteFileById(Files file,Integer id);

}
