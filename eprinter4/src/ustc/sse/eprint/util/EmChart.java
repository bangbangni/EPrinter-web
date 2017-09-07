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
                            "登录", // 图表标题  
                            "月份", // 目录轴的显示标签  
                            "登录次数", // 数值轴的显示标签  
                            dataset, // 数据集  
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                            true,           // 是否显示图例(对于简单的柱状图必须是false)  
                            false,          // 是否生成工具  
                            false           // 是否生成URL链接  
                            );  
          
        //从这里开始  
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
            
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
            
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame  
           
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