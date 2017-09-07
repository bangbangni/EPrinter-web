package ustc.sse.eprint.service;

import java.util.List;

import ustc.sse.eprint.domain.Printer;


public interface PrinterService {

	//获取全部打印机
	public List<Printer> getPrinters();
	//获取正常打印机
	public List<Printer> getOpenPrinters();
}
