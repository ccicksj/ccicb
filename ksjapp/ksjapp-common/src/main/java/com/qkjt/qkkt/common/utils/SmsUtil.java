package com.qkjt.qkkt.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.qkjt.qkkt.common.constants.YuhaoConstants;

public class SmsUtil {
    /**
     * @param mobile 手机号
     * @param content 短信内容
     * @param platforms 平台 1漫道，2聚达通，3天下畅通
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int send(String mobile, String content, int platforms) {
        int status = YuhaoConstants.SMS_Err;
        String url = null;
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        String encode = "gbk";
        try {
            switch (platforms) {
                case 1:
                    encode = "UTF-8";
                    url =
                    "http://sdk2.entinfo.cn:8061/mdsmssend.ashx?sn=DXX-WSS-010-08646&pwd="
                            + Md5.encode("DXX-WSS-010-08646" + "2896df#-").toUpperCase() + "&mobile="
                            + mobile + "&content=" + URLEncoder.encode(content, "UTF-8") + "&ext=&stime=&rrid=&msgfmt=";
                    break;
                case 2:
                        encode = "gbk";
                        url =
                        "http://116.90.87.221/qxt_jtd/sendSms2.jsp?username=ddjy1&pwd=a1a2a3a4&gwid=2&mobile="+mobile+"&msg="
                                + URLEncoder.encode(content, "gbk");
                    break;
                case 3:
                    encode = "UTF-8";
                    url =
                    "http://xtx.telhk.cn:8888/sms.aspx?action=send&userid=4897&account=叮当家医&password=123321&mobile="+mobile+"&content="
                            + URLEncoder.encode(content, "UTF-8")
                            + "&sendTime=&taskName=&checkcontent=1&mobilenumber=1&countnumber=1&telephonenumber=0";
                    break;

                default:
                    url =
                    "http://sdk2.entinfo.cn:8061/mdsmssend.ashx?sn=SDK-WSS-010-07706&pwd="
                            + Md5.encode("SDK-WSS-010-07706" + "4-2B45-4").toUpperCase() + "&mobile="
                            + mobile + "&content=" + content + "&ext=&stime=&rrid=&msgfmt=";
                    break;
            }
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);
            HttpResponse res;
            res = client.execute(get);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                reader =
                        new BufferedReader(new InputStreamReader(res.getEntity().getContent(),
                            encode));
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    result.append(inputLine);
                }
            }
            System.out.println(result.toString());
            switch (platforms) {
                case 1:
                    if(-1==result.toString().indexOf("-")){
                        status=YuhaoConstants.SMS_Success;
                    }else{
                        status=YuhaoConstants.SMS_Faild;
                    }
                    break;
                case 2:
                    if(-1==result.toString().indexOf("-")){
                        status=YuhaoConstants.SMS_Success;
                    }else{
                        status=YuhaoConstants.SMS_Faild;
                    }
                    break;
                case 3:
                    if(-1==result.toString().indexOf("<returnstatus>Faild</returnstatus>")){
                        status=YuhaoConstants.SMS_Success;
                    }else{
                        status=YuhaoConstants.SMS_Faild;
                    }
                    break;
                default:
                    if(-1==result.toString().indexOf("-")){
                        status=YuhaoConstants.SMS_Success;
                    }else{
                        status=YuhaoConstants.SMS_Faild;
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
            return status;
        }
    }
    
    public static void main(String[] args) {
//        send("13811154246", "注册验证码短信：您的注册账号验证码为：opiuyhhh12h3，有效时间1分钟。【仁和云健康】", 3);
        int i = "asdfasdfasdf".toString().indexOf("-");
        System.out.println(i);
    }
}
