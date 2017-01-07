package net.juntech.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

/**
 * <ul>
 * <li>xhl 2016年7月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class WebServiceUtil {

	public static void main(String[] args) throws ServiceException, IOException {
		Map<String, Object> params = new HashMap<>();
		params.put("userName", "xunnuo");
		params.put("passWord", "e10adc3949ba59abbe56e057f20f883e");
		params.put("identify", "XN01");
		params.put("params", "[]");

		String endpoint = "http://218.242.34.56:13388/mop_ws_zs/in?wsdl";
		Service service = new Service();
		Call call = service.createCall();
		call.setTargetEndpointAddress(endpoint);
		call.setOperationName(new QName("AnalysisData")); // 请求方法
		call.addParameter("data", XMLType.XSD_STRING, ParameterMode.IN);// arg0接口参数名称,arg1接口参数类型,arg2传递参数
		call.setReturnType(XMLType.XSD_STRING);// 设置返回类型
		String temp = ObjectUtil.objToJson(params);
		String result = (String) call.invoke(new Object[] { temp });
		// 给方法传递参数，并且调用方法
		System.out.println("result is " + result);
	}

}
