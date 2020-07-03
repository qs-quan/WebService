package com.clients.wsimport;

import wayzim.cn.service.WeatherWS;
import wayzim.cn.service.WeatherWSSoap;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-07-03 11:04
 */
public class WsImportClient {

    public static void main(String[] args) {
        //创建服务视图
        WeatherWS mobileCodeWS = new WeatherWS();
        //获取服务实现类
        WeatherWSSoap weatherWSSoap = mobileCodeWS.getPort(WeatherWSSoap.class);
        //调用查询方法
        String reuslt = weatherWSSoap.getWeather("北京");
        System.out.println(reuslt);
    }
}
