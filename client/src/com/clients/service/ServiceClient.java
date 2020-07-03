package com.clients.service;

import wayzim.cn.service.WeatherWSSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;


/**
 * 
 * <p>Title: ServiceClient.java</p>
 * <p>Description:Service编程实现服务端调用</p>
 */
public class ServiceClient {

	public static void main(String[] args) throws IOException {
		//创建WSDL的URL，注意不是服务地址
		URL url = new URL("http://127.0.0.1:54321/weather?wsdl");
		
		//创建服务名称
		//1.namespaceURI - 命名空间地址        对应wsdl targetNamespace="http://service.cn.wayzim",
		//2.localPart - 服务视图名             对应wsdl serviceName="WeatherWS"
		QName qname = new QName("http://service.cn.wayzim", "WeatherWS");
		
		//创建服务视图
		//参数解释：
		//1.wsdlDocumentLocation - wsdl地址
		//2.serviceName - 服务名称
		Service service = Service.create(url, qname);
		// 获取服务实现类   参数对应 wsdl portType
		// @webservice (name="WeatherWSSoap")   服务视图名
		WeatherWSSoap weatherWSSoap = service.getPort(WeatherWSSoap.class);
//		//调用查询方法
		String result = weatherWSSoap.getWeather("无锡");
		System.out.println(result);
	}
}
