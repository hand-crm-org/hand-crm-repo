package com.hand.frame.util;

import com.hand.frame.common.CommonConst;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpClientUtil {

	/**
	 *  http Get请求
	 * @param url 请求url
	 * @param paramsMap 请求参数
	 * @param headerParamsMap 请求头参数
	 * @return 响应报文
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String httpGet(String url, Map<String, String> paramsMap, Map<String, String> headerParamsMap) throws ClientProtocolException, IOException {
		String result = null;
		String baseUrl;
		// 处理请求参数，把请求参数拼接到url
        if (paramsMap != null)
        {
            List<BasicNameValuePair> params = new ArrayList<>();
            for (Map.Entry<String, String> entry : paramsMap.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                params.add(new BasicNameValuePair(key, value));
            }
            baseUrl = url + "?" + URLEncodedUtils.format(params, CommonConst.UTF8);
        }
        else
        {
            baseUrl = url;
        }
        
        // 处理请求头，把请求头参数放到请求头里
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(baseUrl);
        httpGet.addHeader(CommonConst.CONTENT_TYPE, CommonConst.APPLICATION_JSON);
        httpGet.setHeader(CommonConst.ACCEPT, CommonConst.ACCEPT_APPLICATION_JSON);
        // 传入的header参数
        if (headerParamsMap != null)
        {
            for (Map.Entry<String, String> entry : headerParamsMap.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                httpGet.setHeader(key, value);
            }
        }
        
        // 发起请求
        CloseableHttpResponse res = httpClient.execute(httpGet);
        result = EntityUtils.toString(res.getEntity());
        res.close();
        httpClient.close();
		return result;
	}
	
	/**
	 * http Post请求
	 * @param url url
	 * @param body 请求体
	 * @param headerParamsMap 请求头
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String httpPost(String url, String body, Map<String, String> headerParamsMap) throws ClientProtocolException, IOException {
		String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(CommonConst.CONTENT_TYPE, CommonConst.APPLICATION_JSON);
        httpPost.setHeader(CommonConst.ACCEPT, CommonConst.ACCEPT_APPLICATION_JSON);
        // 传入的header参数
        if (null != headerParamsMap)
        {
            for (Map.Entry<String, String> entry : headerParamsMap.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                httpPost.setHeader(key, value);
            }
        }
        httpPost.setEntity(new StringEntity(body, Charset.forName("UTF-8")));
        // 发起请求
        CloseableHttpResponse res = httpClient.execute(httpPost);
        result = EntityUtils.toString(res.getEntity());
        res.close();
        httpClient.close();
		return result;
	}
	
	/**
	 * http put请求
	 * @param url
	 * @param body
	 * @param headerParamsMap
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String httpPut(String url, String body, Map<String, String> headerParamsMap) throws ClientProtocolException, IOException {
		String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        httpPut.addHeader(CommonConst.CONTENT_TYPE, CommonConst.APPLICATION_JSON);
        httpPut.setHeader(CommonConst.ACCEPT, CommonConst.ACCEPT_APPLICATION_JSON);
        // 传入的header参数
        if (null != headerParamsMap)
        {
            for (Map.Entry<String, String> entry : headerParamsMap.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                httpPut.setHeader(key, value);
            }
        }
        httpPut.setEntity(new StringEntity(body, Charset.forName("UTF-8")));
        // 发起请求
        CloseableHttpResponse res = httpClient.execute(httpPut);
        result = EntityUtils.toString(res.getEntity());
        res.close();
        httpClient.close();
		return result;
	}
	
	public static String httpDelete(String url, Map<String, String> paramsMap,
            Map<String, String> headerParamsMap) throws ClientProtocolException, IOException {
		String result = null;
		String baseUrl;
		// 处理请求参数，把请求参数拼接到url
        if (paramsMap != null)
        {
            List<BasicNameValuePair> params = new ArrayList<>();
            for (Map.Entry<String, String> entry : paramsMap.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                params.add(new BasicNameValuePair(key, value));
            }
            baseUrl = url + "?" + URLEncodedUtils.format(params, CommonConst.UTF8);
        }
        else
        {
            baseUrl = url;
        }
        
        // 处理请求头，把请求头参数放到请求头里
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(baseUrl);
        httpDelete.addHeader(CommonConst.CONTENT_TYPE, CommonConst.APPLICATION_JSON);
        httpDelete.setHeader(CommonConst.ACCEPT, CommonConst.ACCEPT_APPLICATION_JSON);
        // 传入的header参数
        if (headerParamsMap != null)
        {
            for (Map.Entry<String, String> entry : headerParamsMap.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                httpDelete.setHeader(key, value);
            }
        }
        
        // 发起请求
        CloseableHttpResponse res = httpClient.execute(httpDelete);
        result = EntityUtils.toString(res.getEntity());
        res.close();
        httpClient.close();
		return result;
	}
}
