package ustc.sse.eprint.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

@Service
public class EprintUtilImpl implements EprintUtil {

	/* תPDF��ʽֵ */
	private static final int wdFormatPDF = 17;
	private static final int xlFormatPDF = 0;
	private static final int ppFormatPDF = 32;
	private static final int msoTrue = -1;
	private static final int msofalse = 0;

	/* תHTML��ʽֵ */
	private static final int wdFormatHTML = 8;
	private static final int ppFormatHTML = 12;
	private static final int xlFormatHTML = 44;

	/* תTXT��ʽֵ */
	private static final int wdFormatTXT = 2;

	public boolean convert2PDF(String inputFile, String pdfFile) {
		String suffix = getFileSufix(inputFile);
		File file = new File(inputFile);
		if (!file.exists()) {
			System.out.println("�ļ������ڣ�");
			return false;
		}
		if (suffix.equals("pdf")) {
			System.out.println("PDF not need to convert!");
			return false;
		}
		if (suffix.equals("doc") || suffix.equals("docx")
				|| suffix.equals("txt")) {
			return word2PDF(inputFile, pdfFile);
		} else if (suffix.equals("ppt") || suffix.equals("pptx")) {
			return ppt2PDF(inputFile, pdfFile);
		} else if (suffix.equals("xls") || suffix.equals("xlsx")) {
			return excel2PDF(inputFile, pdfFile);
		} else {
			System.out.println("�ļ���ʽ��֧��ת��!");
			return false;
		}
	}

	/**
	 * ��ȡ�ļ���׺
	 * 
	 * @param fileName
	 * @return
	 * @author
	 */
	private String getFileSufix(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(splitIndex + 1);
	}

	/**
	 * Word�ĵ�ת��
	 * 
	 * @param inputFile
	 * @param pdfFile
	 * @author
	 */
	private boolean word2PDF(String inputFile, String pdfFile) {
		ComThread.InitSTA();

		long start = System.currentTimeMillis();
		ActiveXComponent app = null;
		Dispatch doc = null;
		try {
			app = new ActiveXComponent("Word.Application");// ����һ��word����
			app.setProperty("Visible", new Variant(false)); // ���ɼ���word
			app.setProperty("AutomationSecurity", new Variant(3)); // ���ú�
			Dispatch docs = app.getProperty("Documents").toDispatch();// ��ȡ�ĵ�����

			System.out.println("���ĵ� >>> " + inputFile);
			// Object[]�����������Ǳ�ʾ���Ƿ�ֻ����ʽ�򿪡�
			// ����Documents������Open�������ĵ��������ش򿪵��ĵ�����Document
			doc = Dispatch.call(docs, "Open", inputFile, false, true)
					.toDispatch();
			// ����Document�����SaveAs���������ĵ�����Ϊpdf��ʽ
			System.out
					.println("ת���ĵ� [" + inputFile + "] >>> [" + pdfFile + "]");
			Dispatch.call(doc, "SaveAs", pdfFile, wdFormatPDF);// word����Ϊpdf��ʽ�ֵ꣬Ϊ17
			// Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF);
			// // word����Ϊpdf��ʽ�ֵ꣬Ϊ17

			long end = System.currentTimeMillis();

			System.out.println("��ʱ��" + (end - start) + "ms.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("========Error:�ĵ�ת��ʧ�ܣ�" + e.getMessage());
		} finally {
			Dispatch.call(doc, "Close", false);
			System.out.println("�ر��ĵ�");
			if (app != null)
				app.invoke("Quit", new Variant[] {});
		}
		// ���û����仰,winword.exe���̽�����ر�
		ComThread.Release();
		ComThread.quitMainSTA();
		return false;
	}

	/**
	 * PPT�ĵ�ת��
	 * 
	 * @param inputFile
	 * @param pdfFile
	 * @author
	 */
	private boolean ppt2PDF(String inputFile, String pdfFile) {
		ComThread.InitSTA();

		long start = System.currentTimeMillis();
		ActiveXComponent app = null;
		Dispatch ppt = null;
		try {
			app = new ActiveXComponent("PowerPoint.Application");// ����һ��PPT����
			// app.setProperty("Visible", new Variant(false)); //
			// ���ɼ��򿪣�PPTת�����������أ���������Ҫע�͵���
			// app.setProperty("AutomationSecurity", new Variant(3)); // ���ú�
			Dispatch ppts = app.getProperty("Presentations").toDispatch();// ��ȡ�ĵ�����

			System.out.println("���ĵ� >>> " + inputFile);
			// ����Documents������Open�������ĵ��������ش򿪵��ĵ�����Document
			ppt = Dispatch.call(ppts, "Open", inputFile, true,// ReadOnly
					true,// Untitledָ���ļ��Ƿ��б���
					false// WithWindowָ���ļ��Ƿ�ɼ�
					).toDispatch();

			System.out
					.println("ת���ĵ� [" + inputFile + "] >>> [" + pdfFile + "]");
			Dispatch.call(ppt, "SaveAs", pdfFile, ppFormatPDF);

			long end = System.currentTimeMillis();

			System.out.println("��ʱ��" + (end - start) + "ms.");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("========Error:�ĵ�ת��ʧ�ܣ�" + e.getMessage());
		} finally {
			Dispatch.call(ppt, "Close");
			System.out.println("�ر��ĵ�");
			if (app != null)
				app.invoke("Quit", new Variant[] {});
		}
		ComThread.Release();
		ComThread.quitMainSTA();
		return false;
	}

	/**
	 * Excel�ĵ�ת��
	 * 
	 * @param inputFile
	 * @param pdfFile
	 * @author
	 */
	private boolean excel2PDF(String inputFile, String pdfFile) {
		ComThread.InitSTA();

		long start = System.currentTimeMillis();
		ActiveXComponent app = null;
		Dispatch excel = null;
		try {
			app = new ActiveXComponent("Excel.Application");// ����һ��PPT����
			app.setProperty("Visible", new Variant(false)); // ���ɼ���
			// app.setProperty("AutomationSecurity", new Variant(3)); // ���ú�
			Dispatch excels = app.getProperty("Workbooks").toDispatch();// ��ȡ�ĵ�����

			System.out.println("���ĵ� >>> " + inputFile);
			// ����Documents������Open�������ĵ��������ش򿪵��ĵ�����Document
			excel = Dispatch.call(excels, "Open", inputFile, false, true)
					.toDispatch();
			// ����Document���󷽷������ĵ�����Ϊpdf��ʽ
			System.out
					.println("ת���ĵ� [" + inputFile + "] >>> [" + pdfFile + "]");
			// Excel ���ܵ���SaveAs����
			Dispatch.call(excel, "ExportAsFixedFormat", xlFormatPDF, pdfFile);

			long end = System.currentTimeMillis();

			System.out.println("��ʱ��" + (end - start) + "ms.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("========Error:�ĵ�ת��ʧ�ܣ�" + e.getMessage());
		} finally {
			Dispatch.call(excel, "Close", false);
			System.out.println("�ر��ĵ�");
			if (app != null)
				app.invoke("Quit", new Variant[] {});
		}
		ComThread.Release();
		ComThread.quitMainSTA();
		return false;
	}

	@Override
	public String getIpAddress(HttpServletRequest request) {
		/**
		 * ��ȡ�û���ʵIP��ַ����ʹ��request.getRemoteAddr();��ԭ�����п����û�ʹ���˴��������ʽ������ʵIP��ַ,
		 * 
		 * ���ǣ����ͨ���˶༶�������Ļ���X-Forwarded-For��ֵ����ֹһ��������һ��IPֵ�������ĸ������������û��˵���ʵIP�أ�
		 * ����ȡX-Forwarded-For�е�һ����unknown����ЧIP�ַ�����
		 * 
		 * �磺X-Forwarded-For��192.168.1.110, 192.168.1.120, 192.168.1.130,
		 * 192.168.1.100
		 * 
		 * �û���ʵIPΪ�� 192.168.1.110
		 * 
		 * @param request
		 * @return
		 */
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	//md5����
	 public String toMD5(String plainText) {
		 StringBuffer buf=null;
	     try {
	        //����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        //ʹ��ָ�����ֽ��������ժҪ��
	        md.update(plainText.getBytes());
	        //ͨ��ִ���������֮������ղ�����ɹ�ϣ���㡣
	        byte b[] = md.digest();
	        //���ɾ����md5���뵽buf����
	        int i;
	        buf = new StringBuffer("");
	        for (int offset = 0; offset < b.length; offset++) {
	          i = b[offset];
	          if (i < 0)
	            i += 256;
	          if (i < 16)
	            buf.append("0");
	          buf.append(Integer.toHexString(i));
	        }
	        
	        /*System.out.println("16λ: " + buf.toString().substring(8, 24));// 16λ�ļ��ܣ���ʵ����32λ���ܺ�Ľ�ȡ
*/	     } 
	     catch (Exception e) {
	       e.printStackTrace();
	     }
	     
	     return buf.toString();// 32λ�ļ���
	   }

}
