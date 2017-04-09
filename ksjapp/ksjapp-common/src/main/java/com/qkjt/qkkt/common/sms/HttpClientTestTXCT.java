package com.qkjt.qkkt.common.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

//天下畅通
public class HttpClientTestTXCT {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = URLEncoder.encode("默认密码短信：恭喜您成功注册，您的账号：139xxxx 默认密码:xxxx。【仁和云健康】", "UTF-8");
        String url = 
                "http://xtx.telhk.cn:8888/sms.aspx?action=send&userid=4897&account=叮当家医&password=123321&mobile=13717707271&content="+msg+"&sendTime=&taskName=&checkcontent=1&mobilenumber=1&countnumber=1&telephonenumber=0";
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        StringBuffer result = new StringBuffer();
        BufferedReader reader = null;
        try {
            HttpResponse res = client.execute(get);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                reader =
                        new BufferedReader(new InputStreamReader(res.getEntity().getContent(),
                                "UTF-8"));
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
