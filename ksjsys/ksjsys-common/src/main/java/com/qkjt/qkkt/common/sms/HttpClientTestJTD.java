package com.qkjt.qkkt.common.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

//聚通达-已经通了，必须按照模板发
public class HttpClientTestJTD {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = URLEncoder.encode("默认密码短信：恭喜您成功注册，您的账号：139xxxx 默认密码:xxxx。【仁和云健康】", "gbk");
        String url =
                "http://116.90.87.221/qxt_jtd/sendSms2.jsp?username=ddjy1&pwd=a1a2a3a4&gwid=2&mobile=13717707271&msg=" + msg;
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        StringBuffer result = new StringBuffer();
        BufferedReader reader = null;
        try {
            HttpResponse res = client.execute(get);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                reader =
                        new BufferedReader(new InputStreamReader(res.getEntity().getContent(),
                                "gbk"));
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    result.append(inputLine);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (Exception e2) {}
            }
        }
        System.out.println(result.toString());
    }
}
