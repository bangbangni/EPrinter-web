package ustc.sse.eprint.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ustc.sse.eprint.basicdao.BasicDao;
import ustc.sse.eprint.dao.PrinterDao;
import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.domain.Printer;

@Repository
public class PrinterDaoImpl extends BasicDao implements PrinterDao {

	@Override
	public List<Printer> getPrinters() {
		// TODO Auto-generated method stub
		String hql="from Printer";
		String[] parameters=null;
		List<Printer> list = this.executeQueryList(hql, parameters);
		return list;
	}

	@Override
	public Printer getPrinterByID(Printer printer, Integer id) {
		// TODO Auto-generated method stub
		
		return (Printer) this.findById(printer.getClass(), id);
	}

	@Override
	public void addPrinter(Printer printer) {
		// TODO Auto-generated method stub
		this.add(printer);
	}

	@Override
	public void deletePrinterById(Printer printer, Integer fid) {
		// TODO Auto-generated method stub
		this.deleteById(printer.getClass(), fid);
	}

	@Override
	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Printer";
		return this.queryPageCount(hql, null, pageSize);
	}

	@Override
	public List<Printer> getPageList(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Printer p  order by p.id desc";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

	@Override
	public List<Printer> searchPageList(int pageSize, int pageNow,
			String printerName) {;
		String hql = "from Printer c where c.priName like '%"+printerName+"%' order by c.id desc";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

	@Override
	public void modifyPrinter(Printer printer) {
		// TODO Auto-generated method stub
		this.update(printer);
	}

	@Override
	public List<Printer> getOpenPrinters() {
		String hql="from Printer c where c.priState = 0 order by c.id desc ";
		String[] parameters=null;
		List<Printer> list = this.executeQueryList(hql, parameters);
		return list;
	}

}
