package com.jaxws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

/**
 * 
 * <p>Title: WeatherInterfaceImpl.java</p>
 * <p>Description:SEI实现类</p>
 */

//@WebService表示该类是一个服务类，需要发布其中的public的方法
@WebService(
		targetNamespace="http://service.cn.wayzim",
		name="WeatherWSSoap",                         //服务视图名   实现类的名字映射
		portName="WeatherWSSoapPort",
		serviceName="WeatherWS"                       //服务名称
		)
//@BindingType(SOAPBinding.SOAP12HTTP_BINDING)        //wsimport 不支持soap1.2 生成客户端代码
@BindingType(SOAPBinding.SOAP11HTTP_BINDING)          //wsimport 支持soap1.1 生成客户端代码
public class WeatherInterfaceImpl implements WeatherInterface {

	@WebMethod(
			operationName="getWeather",
			exclude=false
			)
	@Override
	public @WebResult(name="result")String queryWeather(@WebParam(name="cityName")String cityName) {
		System.out.println("from client..."+cityName);
		String weather =  cityName + "；晴";
		return weather;
	}

}
