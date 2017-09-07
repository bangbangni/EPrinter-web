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
        //���ô�ӡ���ݵĸ�ʽ���˴�ΪͼƬgif��ʽ  
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.PDF;  
        //������ӡ����  
//      DocAttributeSet docAttr = new HashDocAttributeSet();//�����ĵ�����  
//      Doc myDoc = new SimpleDoc(psStream, psInFormat, docAttr);  
        Doc myDoc = new SimpleDoc(psStream, psInFormat, null);  
          
        //���ô�ӡ����  
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();  
        //aset.add(new Copies(3));//��ӡ������3��  
        aset.add(new Copies(1));
        if(pageSize.equals("ISO_A4")){
        	aset.add(MediaSizeName.ISO_A4);
        }else if(pageSize.equals("ISO_A3")){
        	aset.add(MediaSizeName.ISO_A3);
        }
        //aset.add(Sides.ONE_SIDED);
        //�������д�ӡ����  
        PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);  
  
        System.out.println(services.length);
        // this step is necessary because I have several printers configured  
        //�����в��ҳ����Ĵ�ӡ�����Լ���Ҫ�Ĵ�ӡ������ƥ�䣬�ҳ��Լ���Ҫ�Ĵ�ӡ��  
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
  
        //���������ӡ���ĸ�������  
        AttributeSet att = myPrinter.getAttributes();  
  
        for (Attribute a : att.toArray()) {  
  
            String attributeName;  
            String attributeValue;  
  
            attributeName = a.getName();  
            attributeValue = att.get(a.getClass()).toString();  
  
            System.out.println(attributeName + " : " + attributeValue);  
        }  
  
        if (myPrinter != null) {  
            DocPrintJob job = myPrinter.createPrintJob();//�����ĵ���ӡ��ҵ  
            try {  
                job.print(myDoc, aset);//��ӡ�ĵ�  
  
            } catch (Exception pe) {  
                pe.printStackTrace();  
            }  
        } else {  
            System.out.println("no printer services found");  
        }
	}  

}