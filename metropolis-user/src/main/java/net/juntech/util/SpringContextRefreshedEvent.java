package net.juntech.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import net.juntech.service.wages.IWagesService;
import net.juntech.service.wages.impl.WagesServiceImpl;
/**
 * <ul>
 * <li>ZX 2016年12月29日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class SpringContextRefreshedEvent extends HttpServlet {
	private static Log log = LogFactory.getLog(SpringContextRefreshedEvent.class);
	private static WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
	private static IWagesService wagesService = context.getBean(WagesServiceImpl.class);
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
			log.info("容器开始加载…………………………");
			getWagesAll();
			log.info("容器已经加载完成了");
	}
	
	public static void getWagesAll(){
		long oneDay = 24 * 60 * 60 * 1000;  
	    long initDelay  = getTimeMillis("09:00:00") - System.currentTimeMillis(); 
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					wagesService.selectWagesAll();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//		executor.execute(runnable);
//		executor.scheduleAtFixedRate(runnable, 0, 10*1000, TimeUnit.MILLISECONDS);
		//10秒循环
//		executor.scheduleWithFixedDelay(runnable, 0, 10*1000, TimeUnit.MILLISECONDS);
//	    scheduleAtFixedRate(  
//	    		runnable,  
//	            initDelay,  
//	            oneDay,  
//	            TimeUnit.MILLISECONDS); 
	}
	
	/** 
	 * 获取指定时间对应的毫秒数 
	 * @param time "HH:mm:ss" 
	 * @return 
	 */  
	private static long getTimeMillis(String time) {  
	    try {  
	        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
	        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");  
	        Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);  
	        return curDate.getTime();  
	    } catch (ParseException e) {  
	        e.printStackTrace();  
	    }  
	    return 0;  
	}  
}
