package com.qkjt.qkkt.common.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.qkjt.qkkt.common.utils.Md5;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// 漫道-已通
public class HttpClientTestMD {

    public static String FIND_PASSWORD_VERIFY_CODE_MSG =
            "您在找回密码的过程中，系统为您提供的验证码为:code,请在页面中输入以完成验证。（仁和云健康客服不会索取此验证码）。【仁和云健康】";
    public static String md5 = Md5.encode("SDK-WSS-010-07706" + "4-2B45-4").toUpperCase();

    public static void main(String[] args) throws UnsupportedEncodingException {
        // String msg = URLEncoder.encode("这是一个测试短信--yuhao【仁和云健康】", "gbk");
        String md5 = Md5.encode("SDK-WSS-010-07706" + "4-2B45-4").toUpperCase();
        String url =
                "http://sdk2.entinfo.cn:8061/mdsmssend.ashx?sn=SDK-WSS-010-07706&pwd="
                        + md5
                        + "&mobile=13811154246,18612420100&content=注册验证码短信：您的注册账号验证码为：opiuyhhh12h3，有效时间1分钟。【仁和云健康】&ext=&stime=&rrid=&msgfmt=";
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

    /**
     * 
     * @param mobile
     * @param password
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String sendSms(String mobile, String verifyCode) {
        String content = FIND_PASSWORD_VERIFY_CODE_MSG.replaceAll("code", verifyCode);
        String url =
                "http://sdk2.entinfo.cn:8061/mdsmssend.ashx?sn=SDK-WSS-010-07706&pwd=" + md5
                        + "&mobile=" + mobile + "&content=" + content
                        + "&ext=&stime=&rrid=&msgfmt=";
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
        return result.toString();

    }

    /**
     * 
     * @param mobile
     * @param content
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String send(String mobile, String content) {
        String url =
                "http://sdk2.entinfo.cn:8061/mdsmssend.ashx?sn=SDK-WSS-010-07706&pwd=" + md5
                        + "&mobile=" + mobile + "&content=" + content
                        + "&ext=&stime=&rrid=&msgfmt=";
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        StringBuffer result = new StringBuffer();
        BufferedReader reader = null;

        HttpResponse res;
        try {
            res = client.execute(get);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                reader =
                        new BufferedReader(new InputStreamReader(res.getEntity().getContent(),
                                "gbk"));
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    result.append(inputLine);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
