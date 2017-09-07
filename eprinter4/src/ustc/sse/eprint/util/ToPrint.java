package ustc.sse.eprint.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;

import org.springframework.stereotype.Service;

@Service
public class ToPrint {
	
	public static void printer(String filePath,String printerName,int pageNum,String pageSize) {
		FileInputStream psStream = null;  
        try {  
            psStream = new FileInputStream(filePath);  
        } catch (FileNotFoundException ffne) {  
            ffne.printStackTrace();  
        }  
        if (psStream == null) {  
            return;  
        }  
        //设置打印数据的格式，此处为图片gif格式  
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.PDF;  
        //创建打印数据  
//      DocAttributeSet docAttr = new HashDocAttributeSet();//设置文档属性  
//      Doc myDoc = new SimpleDoc(psStream, psInFormat, docAttr);  
        Doc myDoc = new SimpleDoc(psStream, psInFormat, null);  
          
        //设置打印属性  
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();  
        //aset.add(new Copies(3));//打印份数，3份  
        aset.add(new Copies(1));
        if(pageSize.equals("ISO_A4")){
        	aset.add(MediaSizeName.ISO_A4);
        }else if(pageSize.equals("ISO_A3")){
        	aset.add(MediaSizeName.ISO_A3);
        }
        //aset.add(Sides.ONE_SIDED);
        //查找所有打印服务  
        PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);  
  
        System.out.println(services.length);
        // this step is necessary because I have several printers configured  
        //将所有查找出来的打印机与自己想要的打印机进行匹配，找出自己想要的打印机  
        PrintService myPrinter = null;  
        for (int i = 0; i < services.length; i++) {  
            System.out.println("service found: " + services[i]);  
            String svcName = services[i].toString();  
            if (svcName.contains("pdfFactory Pro")) {  
                myPrinter = services[i];  
                System.out.println("my printer found: " + svcName);  
                System.out.println("my printer found: " + myPrinter);  
                break;  
            }  
        }  
  
        //可以输出打印机的各项属性  
        AttributeSet att = myPrinter.getAttributes();  
  
        for (Attribute a : att.toArray()) {  
  
            String attributeName;  
            String attributeValue;  
  
            attributeName = a.getName();  
            attributeValue = att.get(a.getClass()).toString();  
  
            System.out.println(attributeName + " : " + attributeValue);  
        }  
  
        if (myPrinter != null) {  
            DocPrintJob job = myPrinter.createPrintJob();//创建文档打印作业  
            try {  
                job.print(myDoc, aset);//打印文档  
  
            } catch (Exception pe) {  
                pe.printStackTrace();  
            }  
        } else {  
            System.out.println("no printer services found");  
        }
	}  

}
