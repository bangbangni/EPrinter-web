package ustc.sse.eprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ustc.sse.eprint.dao.PrinterDao;
import ustc.sse.eprint.domain.Printer;
import ustc.sse.eprint.service.PrinterService;

@Service
public class PrinterServiceImpl implements PrinterService {

	@Autowired
	PrinterDao printerDao;
	@Override
	public List<Printer> getPrinters() {
		// TODO Auto-generated method stub
		return printerDao.getPrinters();
	}
	@Override
	public List<Printer> getOpenPrinters() {
		// TODO Auto-generated method stub
		return printerDao.getOpenPrinters();
	}

}
