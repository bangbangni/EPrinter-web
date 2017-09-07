package ustc.sse.eprint.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.basicdao.BasicDao;
import ustc.sse.eprint.dao.FileDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.domain.Printer;

@Repository
public class FileDaoImpl extends BasicDao implements FileDao {

	@Override
	public Files getFilesByID(Files file, Integer id) {
		// TODO Auto-generated method stub
		// 需要类的反射，直接新建一个类即可，不一定和你要删的实例相关
		return (Files) this.findById(file.getClass(), id);
	}

	@Override
	public void addFile(Files file) {
		// TODO Auto-generated method stub
		this.add(file);

	}

	@Override
	public List<Files> getFilesByEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// 通过外键获取 desc递减 asc递增
		String hql = "from Files c where c.employee.id=? order by c.uploadTime desc ";

		// 为什么Object而非String，应为会报java.lang.ClassCastException: java.lang.String
		// cannot be cast to java.lang.Integer
		// String[] parameters={employee.getId().toString()};改为
		Object[] parameters = { employee.getId() };
		List<Files> list = this.executeQueryList(hql, parameters);
		return list;
	}

	@Override
	public void deleteFileById(Files file, Integer fid) {
		this.deleteById(file.getClass(), fid);

	}

	@Override
	public int getPageCount(int pageSize, Object ForeignObj) {
		// TODO Auto-generated method stub
		if (ForeignObj instanceof Employee) {
			Employee employee = (Employee)ForeignObj;
			String hql = "select count(*) from Files c where c.employee.id=?";
			Object[] parameters = {employee.getId()};
			return this.queryPageCount(hql, parameters, pageSize);
		}else if(ForeignObj instanceof Printer){
			Printer printer = (Printer)ForeignObj;
			String hql = "select count(*) from Files c where c.printer.id=?";
			Object[] parameters = {printer.getId()};
			return this.queryPageCount(hql, parameters, pageSize);
		}else{
			//输入错误
			return (Integer) null;
		}
	}

	@Override
	public List<Files> getPageList( Object ForeignObj,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		if (ForeignObj instanceof Employee) {
			Employee employee = (Employee)ForeignObj;
			String hql = "from Files c where c.employee.id=? order by c.uploadTime desc ";
			Object[] parameters = {employee.getId()};
			return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
		}else if(ForeignObj instanceof Printer){
			Printer printer = (Printer)ForeignObj;
			String hql = "from Files c where c.printer.id=? order by c.uploadTime desc ";
			Object[] parameters = {printer.getId()};
			return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
		}else{
			//输入错误
			return null;
		}
	}

	@Override
	public List<Files> searchPageList(Object ForeignObj, int pageSize,
			int pageNow,String filename) {
		// TODO Auto-generated method stub
				if (ForeignObj instanceof Employee) {
					Employee employee = (Employee)ForeignObj;
					String hql = "from Files c where c.employee.id=? and c.fileName like '%"+filename+"%' order by c.uploadTime desc ";
					Object[] parameters = {employee.getId()};
					return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
				}else if(ForeignObj instanceof Printer){
					Printer printer = (Printer)ForeignObj;
					String hql = "from Files c where c.printer.id=? order by c.uploadTime desc ";
					Object[] parameters = {printer.getId()};
					return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
				}else{
					//输入错误
					return null;
				}
	}

	@Override
	public int searchPageCount(int pageSize, Object ForeignObj, String filename) {
		// TODO Auto-generated method stub
				if (ForeignObj instanceof Employee) {
					Employee employee = (Employee)ForeignObj;
					String hql = "select count(*) from Files c where c.employee.id=? and c.fileName like '%"+filename+"%'";
					Object[] parameters = {employee.getId()};
					return this.queryPageCount(hql, parameters, pageSize);
				}else if(ForeignObj instanceof Printer){
					Printer printer = (Printer)ForeignObj;
					String hql = "select count(*) from Files c where c.printer.id=? and c.fileName like '%"+filename+"%'";
					Object[] parameters = {printer.getId()};
					return this.queryPageCount(hql, parameters, pageSize);
				}else{
					//输入错误
					return (Integer) null;
				}
	}

	@Override
	public long getAllPages(Object ForeignObj) {
		// TODO Auto-generated method stub
		if (ForeignObj instanceof Employee) {
			Employee employee = (Employee)ForeignObj;
			String hql = "select sum(c.filePages) from Files c where c.employee.id=? and c.fileState=1";
			Object[] parameters = {employee.getId()};
			if(this.executeQueryUnique(hql, parameters)==null)
				return 0;
			return (Long) this.executeQueryUnique(hql, parameters);
		}else if(ForeignObj instanceof Printer){
			Printer printer = (Printer)ForeignObj;
			String hql = "select sum(c.filePages) from Files c where c.printer.id=? and c.fileState=1";
			Object[] parameters = {printer.getId()};
			if(this.executeQueryUnique(hql, parameters)==null)
				return 0;
			return (long) this.executeQueryUnique(hql, parameters);
		}else{
			//输入错误
			return 0;
		}
	}

	@Override
	public long getYMPages(Object ForeignObj, String yearMo) {
		// TODO Auto-generated method stub
		String hql;
		if (ForeignObj instanceof Employee) {
			Employee employee = (Employee)ForeignObj;
			if(yearMo.split("-")[1].equals("1")){
				hql = "select sum(c.filePages) from Files c where c.employee.id=? and c.fileState=1 and c.uploadTime like '%"+yearMo+"-"+"%'";
			}
			else{
				hql = "select sum(c.filePages) from Files c where c.employee.id=? and c.fileState=1 and c.uploadTime like '%"+yearMo+"%'";
			}
			Object[] parameters = {employee.getId()};
			if(this.executeQueryUnique(hql, parameters)==null)
				return 0;
			return (Long) this.executeQueryUnique(hql, parameters);
		}else if(ForeignObj instanceof Printer){
			Printer printer = (Printer)ForeignObj;
			if(yearMo.split("-")[1].equals("1")){
				hql = "select sum(c.filePages) from Files c where c.employee.id=? and c.fileState=1 and c.uploadTime like '%"+yearMo+"-"+"%'";
			}
			else{
				hql = "select sum(c.filePages) from Files c where c.employee.id=? and c.fileState=1 and c.uploadTime like '%"+yearMo+"%'";
			}			Object[] parameters = {printer.getId()};
			if(this.executeQueryUnique(hql, parameters)==null)
				return 0;
			return (long) this.executeQueryUnique(hql, parameters);
		}else{
			//输入错误
			return 0;
		}
	}

	@Override
	public void modifyFile(Files file) {
		this.update(file);
		
	}

	@Override
	public int getPageCount(int pageSize) {
		String hql = "select count(*) from Files c where c.fileMark=1";
		
		return this.queryPageCount(hql, null, pageSize);
	}

	@Override
	public List<Files> getPageList(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Files c where c.fileMark=1 order by c.uploadTime desc ";
		return this.executeQueryByPage(hql,null, pageSize, pageNow);
	}

	@Override
	public List<Files> searchPageList(int pageSize, int pageNow, String filename) {
		String hql = "from Files c where c.fileMark=1 and c.fileName like '%"+filename+"%' order by c.uploadTime desc ";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

	@Override
	public int searchPageCount(int pageSize, String filename) {
		String hql = "select count(*) from Files c where c.fileMark=1 and c.fileName like '%"+filename+"%'";
		return this.queryPageCount(hql,null, pageSize);
	}

}
