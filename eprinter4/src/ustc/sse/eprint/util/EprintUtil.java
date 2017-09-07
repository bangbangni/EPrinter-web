package ustc.sse.eprint.util;

import javax.servlet.http.HttpServletRequest;

public interface EprintUtil {
	
	
	public boolean convert2PDF(String inputFile, String pdfFile);
	public String getIpAddress(HttpServletRequest request); 
	
	public String toMD5(String plainText);
	
}
