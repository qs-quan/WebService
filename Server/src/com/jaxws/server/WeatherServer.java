package com.jaxws.server;

import javax.xml.ws.Endpoint;

/**
 * 
 * <p>Title: WeatherServer.java</p>
 * <p>Description:天气服务端</p>
 */
public class WeatherServer {

	public static void main(String[] args) {
		//Endpoint发布服务
		//参数解释
		//1.address - 服务地址
		//2.implementor - 实现类
		Endpoint.publish("http://127.0.0.1:12345/weather", new WeatherInterfaceImpl());
	}
}
