package ustc.sse.eprint.controller;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ustc.sse.eprint.domain.Employee;
import ustc.sse.eprint.domain.EmployeeLog;
import ustc.sse.eprint.service.EmployeeService;
import ustc.sse.eprint.util.EmChart;

@Controller
public class EmployeeLogCol {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/userLog")
	public String emLog(Map<String,Object> map,HttpServletRequest request){
		int nubmer[]={0,0,0,0,0,0,0,0,0,0,0,0};
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		System.out.println(employeeService.getLog(employee).size());
		
		Set<EmployeeLog> logs = employeeService.getLog(employee);
		for(EmployeeLog log:logs){
			String time= log.getLonginTime().toString();
			String splitTime = TimeSplit(time);
			//System.out.println(splitTime);
			int a=Calendar.getInstance().get(Calendar.YEAR);//得到年,int类型
			//System.out.println("年份："+a);
			
			
			if(splitTime.compareTo(a+"-"+"01")>=0){
				if(splitTime.compareTo(a+"-"+"02")<0){
					++nubmer[0];
					System.out.println("111");
				}else{
					if(splitTime.compareTo(a+"-"+"03")<0){
						++nubmer[1];
					}else{
						if(splitTime.compareTo(a+"-"+"04")<0){
							++nubmer[2];
						}else{
							if(splitTime.compareTo(a+"-"+"05")<0){
								++nubmer[3];
							}else{
								if(splitTime.compareTo(a+"-"+"06")<0){
									++nubmer[4];
								}else{
									if(splitTime.compareTo(a+"-"+"07")<0){
										++nubmer[5];
									}else{
										if(splitTime.compareTo(a+"-"+"08")<0){
											++nubmer[6];
										}else{
											if(splitTime.compareTo(a+"-"+"09")<0){
												++nubmer[7];
											}else{
												if(splitTime.compareTo(a+"-"+"10")<0){
													++nubmer[8];
												}else{
													if(splitTime.compareTo(a+"-"+"11")<0){
														++nubmer[9];
													}else{
														if(splitTime.compareTo(a+"-"+"12")<0){
															++nubmer[10];
														}else{
															++nubmer[11];
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
						
				}
			}
		}
        int all =0;
	    for(int num : nubmer){
			all +=num;
		}
		JFrame frame=new JFrame("Java数据统计图");  
	    frame.setLayout(new GridLayout(2,2,10,10));  
	    frame.add(new EmChart(nubmer).getChartPanel());           //添加柱形图  
	    frame.setBounds(50, 50, 800, 600);  
	    //frame.setVisible(true);  
		
		
		map.put("Allnumber",all);
		map.put("chart", frame);
/*		model.addAttribute("Allnumber", employeeService.getLog(employee).size());*/
		/*model.addAllAttributes("numbers",nubmer);*/
		map.put("numbers", nubmer);
		return "userLog";
	}
	
	//切割时间
	public static String TimeSplit(String times){
		String time1=times.split(" ")[0];
		String[] time2 = time1.split("-");
		return time2[0] +"-"+time2[1];				
	}

}
