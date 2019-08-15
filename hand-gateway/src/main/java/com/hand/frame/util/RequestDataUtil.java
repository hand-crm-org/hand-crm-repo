package com.hand.frame.util;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取对应请求方法中的请求参数并执行请求
 */
public class RequestDataUtil {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";
    private static String METHOD_PUT = "PUT";
    private static String METHOD_DELETE = "DELETE";
    /**
     * GET、DELETE请求
     * @param request
     * @return map
     */
    public static String doGet(HttpServletRequest request,String url,String method){
        Map<String,String> headerMap = new HashMap<>();
        Map<String,String> paramsMap = new HashMap<>();
        Enumeration<?> temp = request.getParameterNames();
        String reponse = null;
        if(null != temp){
            while (temp.hasMoreElements()){
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                paramsMap.put(en,value);
            }
        }
        try {
            if(METHOD_GET.equals(method)){
                reponse = HttpClientUtil.httpGet(url,paramsMap,headerMap);
            }
            else if(METHOD_DELETE.equals(method)){
                reponse = HttpClientUtil.httpDelete(url,paramsMap,headerMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
            reponse = "exception";
        }
        return reponse;
    }

    /**
     * POST、PUT请求
     * @param request
     * @return body
     */
    public static String doPost(HttpServletRequest request,String url,String method){
        Map<String,String> map = new HashMap<>();
        BufferedReader reader = null;
        String response = null;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String body = "";
            String str = "";
            while((str = reader.readLine())!=null){
                body += str;
            }
            if(METHOD_POST.equals(method)){
                //POST请求
                response = HttpClientUtil.httpPost(url,body,map);
            }
            else if(METHOD_PUT.equals(method)){
                //PUT请求
                response = HttpClientUtil.httpPut(url,body,map);
            }
        } catch (IOException e) {
            e.printStackTrace();
            response = "exception";
        }
        return response;
    }
}
