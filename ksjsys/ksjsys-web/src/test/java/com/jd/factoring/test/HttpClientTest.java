package com.jd.factoring.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;


public class HttpClientTest extends BaseTest {
	public static void main(String[] args){
	    
	    Map<String,Object> map = new HashMap<String, Object>() ;
	    //map.put("phone", "18612420100") ;
	    //map.put("sn", "00771022018002") ;
	    //map.put("type", "1") ;
	    map.put("phone", "13161529757") ;
	    map.put("content", "尊敬的马，感谢您使用(仁和集团)叮当云健康智能一体机，您本次的检测结果为:身高:153.0cm,体重:62.7Kg,BMI:26.8,您超重,幸福源自健康!关爱健康,更关爱您,欢迎再次使用。客服4006-123-133【叮当云健康】") ;
		Gson gson=new Gson(); 
		String json = gson.toJson(map);
		String url = "http://localhost:8080/sms/send";
	    HttpClient client = new DefaultHttpClient();  
	    HttpPost post = new HttpPost(url);  
	    JSONObject response = null;  
	    StringBuffer result=new StringBuffer();  
	    try {  
	        StringEntity s = new StringEntity(json,"utf-8");  
	        s.setContentEncoding("UTF-8");  
	        s.setContentType("application/json");  
	        post.setEntity(s);  
	         
	        HttpResponse res = client.execute(post);  
	        if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){  
	        	HttpEntity entity = res.getEntity(); 
	            String charset = EntityUtils.getContentCharSet(entity); 
	            BufferedReader reader=new BufferedReader(  
                        new InputStreamReader(res.getEntity().getContent(),charset)       
                     );  
             String inputLine=null;  
             while((inputLine=reader.readLine())!=null){  
                    result.append(inputLine);  
             }  
             
	        }  
	    } catch (Exception e) {  
	        throw new RuntimeException(e);  
	    }  
	   System.out.println(result.toString());
	}
	
}
