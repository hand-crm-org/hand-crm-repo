package com.hand.controller;

import com.hand.frame.util.HttpClientUtil;
import net.sf.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class GatewayController {
    @Value(value = "${demo.ip}")
    private String ip;
    @Value(value = "${demo.host}")
    private String host;

    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";
    private static String METHOD_PUT = "PUT";
    private static String METHOD_DELETE = "DELETE";

    @PostMapping("/doDemo")
    public String doRequest(HttpServletRequest request) {
        Map<String, String> headerMap = new HashMap<>();
        Map<String, String> paramsMap = new HashMap<>();
        String body = "";
        String response = "";

        try {
            //获取请求参数并封装为JSON
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String str = "";
            while ((str = reader.readLine()) != null) {
                body += str;
            }
            JSONObject jsonObject = JSONObject.fromObject(body);
            String api = jsonObject.getString("api");
            String url = "http://" + ip + ":" + host + "/demo/" + api;
            String method = jsonObject.getString("method");
            JSONObject data = JSONObject.fromObject(jsonObject.getString("data"));

            //如果为GET或者DELETE请求，将data封装为map
            if (METHOD_GET.equals(method) || METHOD_DELETE.equals(method)) {
                //利用迭代遍历data
                Iterator<String> it = data.keys();
                String key = "";
                String value = "";
                while (it.hasNext()) {
                    key = it.next();
                    value = data.getString(key);
                    paramsMap.put(key, value);
                }
                if (METHOD_GET.equals(method)) {
                    response = HttpClientUtil.httpGet(url, paramsMap, headerMap);
                } else {
                    response = HttpClientUtil.httpDelete(url, paramsMap, headerMap);
                }
            }
            //如果为POST或者PUT请求，将data封装为json格式的字符串
            else if(METHOD_POST.equals(method)){
                //POST请求
                response = HttpClientUtil.httpPost(url,data.toString(),headerMap);
            }
            else if(METHOD_PUT.equals(method)){
                //PUT请求
                response = HttpClientUtil.httpPut(url,data.toString(),headerMap);
            }
        }catch (IOException e) {
            e.printStackTrace();
            response = "exception";
        }
        return response;
    }
}
