package com.new4s.weibao.util;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Send SMS
 * 
 * return xml :
 * 
 * <?xml version="1.0" encoding="utf-8" ?>
 *   <returnsms>
 *      <returnstatus>Success</returnstatus>
 *      <message>ok</message>
 *      <remainpoint>45057</remainpoint>
 *      <taskID>2049722</taskID>
 *      <successCounts>1</successCounts>
 *   </returnsms>
 * 
 * @author zhongbh
 * @version $Id: HttpcomponentsUtil.java, v 0.1 2015年12月30日 下午2:30:13 zhongbh Exp $
 * 
 */
public final class HttpcomponentsUtil {

    private static final Logger logger                             = LoggerFactory
                                                                       .getLogger(HttpcomponentsUtil.class);

    private static final String EMPTY                              = "";
    private static final String DEFAULT_ENCODE                     = Consts.UTF_8.name();
    private static int          DEFAULT_SOCKET_TIMEOUT             = 5000;
    private static int          DEFAULT_CONNECT_TIMEOUT            = 5000;
    private static int          DEFAULT_CONNECTION_REQUEST_TIMEOUT = 5000;

    /**
     * send post request
     * return <tt>String</tt>
     */
    public static String postReq(List<NameValuePair> nvps,String requestUrl) throws Exception {
        String result = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(requestUrl);
            RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT)
                .setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(DEFAULT_CONNECTION_REQUEST_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
//            httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//            httpPost.setHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
//            httpPost.setHeader("Accept-Encoding","gzip, deflate");
//            httpPost.setHeader("Accept-Language","en,zh-CN;q=0.9,zh;q=0.8");
//            httpPost.setHeader("Cache-Control","max-age=0");
//            httpPost.setHeader("Connection","keep-alive");
//            httpPost.setHeader("Host","tae.xmluren.com");
//            httpPost.setHeader("Upgrade-Insecure-Requests","1");
            
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_ENCODE));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    result = EntityUtils.toString(entity);
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return result;
    }

    /**
     * send post request
     * return <tt>String</tt>
     */
    public static String postReq(Map<String, String> params,String requestUrl) throws Exception {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Iterator<String> it = params.keySet().iterator(); it.hasNext();) {
            String key = it.next();
            String val = params.get(key);
            nvps.add(new BasicNameValuePair(key, val));
        }
        return postReq(nvps,requestUrl);
    }

    /**
     * <p>create <tt>NameValuePair</tt> objects
     */
    public static <T> List<NameValuePair> getNameValuePairs(Class<T> ct, T obj) throws Exception {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Field[] fields = ct.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            String key = field.getName();
            String val = emptyFilter(field.get(obj));
            nvps.add(new BasicNameValuePair(key, val));
        }
        return nvps;
    }

    /**
     * null 2 empty
     */
    public static String emptyFilter(Object val) {
        if (val == null)
            return EMPTY;
        return val.toString().trim();
    }

}
