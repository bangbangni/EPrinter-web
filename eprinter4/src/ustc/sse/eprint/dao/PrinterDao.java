package ustc.sse.eprint.dao;

import java.util.List;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.domain.Printer;

public interface PrinterDao {

	//获取打印机
	public List<Printer> getPrinters();
	//获取正常打印机
	public List<Printer> getOpenPrinters();
	//通过文件id获取打印机
	public Printer getPrinterByID(Printer printer,Integer id);
	//添加打印机
	public void addPrinter(Printer printer);
	//通过文件id删除打印机
	public void deletePrinterById(Printer printer,Integer fid);
	//获取总的页数
	public int getPageCount(int pageSize);
	//获取对应分页每页显示
	public List<Printer> getPageList(int pageSize,int pageNow);
	//模糊搜索文件
	public List<Printer> searchPageList(int pageSize,int pageNow,String printerName);
	//更新打印机信息
	public void modifyPrinter(Printer printer);
}
