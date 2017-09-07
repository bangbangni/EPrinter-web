package ustc.sse.eprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ustc.sse.eprint.dao.FileDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	FileDao fileDao;
	
	@Override
	public void addFile(Files file) {
		// TODO Auto-generated method stub
		fileDao.addFile(file);

	}

	@Override
	public List<Files> getFilesByEm(Employee employee) {
		// TODO Auto-generated method stub
		return fileDao.getFilesByEmployee(employee);
	}

	@Override
	public void deleteFileById(Files file, Integer id) {
		fileDao.deleteFileById(file, id);
		
	}

	@Override
	public Files getFileById(Files file, Integer id) {
		// TODO Auto-generated method stub
		return fileDao.getFilesByID(file, id);
	}

}
