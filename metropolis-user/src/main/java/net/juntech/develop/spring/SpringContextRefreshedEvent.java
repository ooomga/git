package net.juntech.develop.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * spring 容器初始化完成事件
 * <ul>
 * <li>{@link #LoginInterceptor()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月12日
 * 
 */
public class SpringContextRefreshedEvent implements ApplicationListener<ContextRefreshedEvent> {

	private Log log = LogFactory.getLog(SpringContextRefreshedEvent.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("容器已经加载完成了");
	}

}
