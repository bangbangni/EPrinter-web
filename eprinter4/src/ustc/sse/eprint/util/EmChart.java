package ustc.sse.eprint.util;

import java.awt.Font;  
import java.util.List;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class EmChart {  
    ChartPanel frame1;  
    public  EmChart(int number[]){  
        CategoryDataset dataset = getDataSet(number);  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                            "��¼", // ͼ�����  
                            "�·�", // Ŀ¼�����ʾ��ǩ  
                            "��¼����", // ��ֵ�����ʾ��ǩ  
                            dataset, // ���ݼ�  
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
                            false,          // �Ƿ����ɹ���  
                            false           // �Ƿ�����URL����  
                            );  
          
        //�����￪ʼ  
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������  
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�  
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
            
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������  
            
         frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame  
           
    }  
       private static CategoryDataset getDataSet(int number[]) {  
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
           Integer i=0;
           for(Integer num:number){
        	   dataset.addValue(num, (++i).toString(),(i).toString()); 
           }
           
         /*  dataset.addValue(100, "1", "1");  
           dataset.addValue(100, "2", "2");  
           dataset.addValue(100, "3", "3");  
           dataset.addValue(200, "4", "4");  
           dataset.addValue(200, "5", "5");  
           dataset.addValue(200, "6", "6");  
           dataset.addValue(300, "7", "7");  
           dataset.addValue(300, "8", "8");  
           dataset.addValue(300, "9", "9");  
           dataset.addValue(400, "10", "10");  
           dataset.addValue(400, "11", "11");  
           dataset.addValue(500, "12", "12");    */
           return dataset;  
}  
public ChartPanel getChartPanel(){  
    return frame1;  
      
}  
}  