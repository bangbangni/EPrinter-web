package ustc.sse.eprint.service;

import java.util.List;

import ustc.sse.eprint.domain.Printer;


public interface PrinterService {

	//��ȡȫ����ӡ��
	public List<Printer> getPrinters();
	//��ȡ������ӡ��
	public List<Printer> getOpenPrinters();
}
