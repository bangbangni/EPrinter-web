package ustc.sse.eprint.dao;

import java.util.List;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.Files;
import ustc.sse.eprint.domain.Printer;

public interface PrinterDao {

	//��ȡ��ӡ��
	public List<Printer> getPrinters();
	//��ȡ������ӡ��
	public List<Printer> getOpenPrinters();
	//ͨ���ļ�id��ȡ��ӡ��
	public Printer getPrinterByID(Printer printer,Integer id);
	//��Ӵ�ӡ��
	public void addPrinter(Printer printer);
	//ͨ���ļ�idɾ����ӡ��
	public void deletePrinterById(Printer printer,Integer fid);
	//��ȡ�ܵ�ҳ��
	public int getPageCount(int pageSize);
	//��ȡ��Ӧ��ҳÿҳ��ʾ
	public List<Printer> getPageList(int pageSize,int pageNow);
	//ģ�������ļ�
	public List<Printer> searchPageList(int pageSize,int pageNow,String printerName);
	//���´�ӡ����Ϣ
	public void modifyPrinter(Printer printer);
}
