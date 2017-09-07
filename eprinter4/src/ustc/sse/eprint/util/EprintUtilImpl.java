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

	/* 转PDF格式值 */
	private static final int wdFormatPDF = 17;
	private static final int xlFormatPDF = 0;
	private static final int ppFormatPDF = 32;
	private static final int msoTrue = -1;
	private static final int msofalse = 0;

	/* 转HTML格式值 */
	private static final int wdFormatHTML = 8;
	private static final int ppFormatHTML = 12;
	private static final int xlFormatHTML = 44;

	/* 转TXT格式值 */
	private static final int wdFormatTXT = 2;

	public boolean convert2PDF(String inputFile, String pdfFile) {
		String suffix = getFileSufix(inputFile);
		File file = new File(inputFile);
		if (!file.exists()) {
			System.out.println("文件不存在！");
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
			System.out.println("文件格式不支持转换!");
			return false;
		}
	}

	/**
	 * 获取文件后缀
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
	 * Word文档转换
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
			app = new ActiveXComponent("Word.Application");// 创建一个word对象
			app.setProperty("Visible", new Variant(false)); // 不可见打开word
			app.setProperty("AutomationSecurity", new Variant(3)); // 禁用宏
			Dispatch docs = app.getProperty("Documents").toDispatch();// 获取文挡属性

			System.out.println("打开文档 >>> " + inputFile);
			// Object[]第三个参数是表示“是否只读方式打开”
			// 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
			doc = Dispatch.call(docs, "Open", inputFile, false, true)
					.toDispatch();
			// 调用Document对象的SaveAs方法，将文档保存为pdf格式
			System.out
					.println("转换文档 [" + inputFile + "] >>> [" + pdfFile + "]");
			Dispatch.call(doc, "SaveAs", pdfFile, wdFormatPDF);// word保存为pdf格式宏，值为17
			// Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF);
			// // word保存为pdf格式宏，值为17

			long end = System.currentTimeMillis();

			System.out.println("用时：" + (end - start) + "ms.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("========Error:文档转换失败：" + e.getMessage());
		} finally {
			Dispatch.call(doc, "Close", false);
			System.out.println("关闭文档");
			if (app != null)
				app.invoke("Quit", new Variant[] {});
		}
		// 如果没有这句话,winword.exe进程将不会关闭
		ComThread.Release();
		ComThread.quitMainSTA();
		return false;
	}

	/**
	 * PPT文档转换
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
			app = new ActiveXComponent("PowerPoint.Application");// 创建一个PPT对象
			// app.setProperty("Visible", new Variant(false)); //
			// 不可见打开（PPT转换不运行隐藏，所以这里要注释掉）
			// app.setProperty("AutomationSecurity", new Variant(3)); // 禁用宏
			Dispatch ppts = app.getProperty("Presentations").toDispatch();// 获取文挡属性

			System.out.println("打开文档 >>> " + inputFile);
			// 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
			ppt = Dispatch.call(ppts, "Open", inputFile, true,// ReadOnly
					true,// Untitled指定文件是否有标题
					false// WithWindow指定文件是否可见
					).toDispatch();

			System.out
					.println("转换文档 [" + inputFile + "] >>> [" + pdfFile + "]");
			Dispatch.call(ppt, "SaveAs", pdfFile, ppFormatPDF);

			long end = System.currentTimeMillis();

			System.out.println("用时：" + (end - start) + "ms.");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("========Error:文档转换失败：" + e.getMessage());
		} finally {
			Dispatch.call(ppt, "Close");
			System.out.println("关闭文档");
			if (app != null)
				app.invoke("Quit", new Variant[] {});
		}
		ComThread.Release();
		ComThread.quitMainSTA();
		return false;
	}

	/**
	 * Excel文档转换
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
			app = new ActiveXComponent("Excel.Application");// 创建一个PPT对象
			app.setProperty("Visible", new Variant(false)); // 不可见打开
			// app.setProperty("AutomationSecurity", new Variant(3)); // 禁用宏
			Dispatch excels = app.getProperty("Workbooks").toDispatch();// 获取文挡属性

			System.out.println("打开文档 >>> " + inputFile);
			// 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
			excel = Dispatch.call(excels, "Open", inputFile, false, true)
					.toDispatch();
			// 调用Document对象方法，将文档保存为pdf格式
			System.out
					.println("转换文档 [" + inputFile + "] >>> [" + pdfFile + "]");
			// Excel 不能调用SaveAs方法
			Dispatch.call(excel, "ExportAsFixedFormat", xlFormatPDF, pdfFile);

			long end = System.currentTimeMillis();

			System.out.println("用时：" + (end - start) + "ms.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("========Error:文档转换失败：" + e.getMessage());
		} finally {
			Dispatch.call(excel, "Close", false);
			System.out.println("关闭文档");
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
		 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
		 * 
		 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
		 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
		 * 
		 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
		 * 192.168.1.100
		 * 
		 * 用户真实IP为： 192.168.1.110
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
	
	//md5加密
	 public String toMD5(String plainText) {
		 StringBuffer buf=null;
	     try {
	        //生成实现指定摘要算法的 MessageDigest 对象。
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        //使用指定的字节数组更新摘要。
	        md.update(plainText.getBytes());
	        //通过执行诸如填充之类的最终操作完成哈希计算。
	        byte b[] = md.digest();
	        //生成具体的md5密码到buf数组
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
	        
	        /*System.out.println("16位: " + buf.toString().substring(8, 24));// 16位的加密，其实就是32位加密后的截取
*/	     } 
	     catch (Exception e) {
	       e.printStackTrace();
	     }
	     
	     return buf.toString();// 32位的加密
	   }

}
