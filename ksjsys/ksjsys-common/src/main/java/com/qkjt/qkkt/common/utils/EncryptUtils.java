package com.qkjt.qkkt.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 生成签名的工具类
 * 
 * @author huoxinpeng
 * 
 */
public class EncryptUtils {
	private static Log logger = LogFactory.getLog(EncryptUtils.class);

	/**
	 * 生成加密的数字签名
	 * 
	 * @param map
	 *            :存放客户端的参数信息
	 * @return
	 */
	public static String generateSign(Map<String, Object> map,String apiName,String secretKey) {
		String str = getStrExcludeSign(map);
		
		//加密规则
		String result = MD5Util.md5Hex(apiName + str + secretKey).toUpperCase();
		logger.debug("==========================================>>>>> apiName = " + apiName);
		logger.debug("==========================================>>>>> middle param and value = " + str);
		logger.debug("==========================================>>>>> secretKey = " + secretKey);
		logger.debug("==========================================>>>>> encrypt result = " + result);
		return result;
	}
	
	
	/**
	 * 获得拼接后的中间字符串
	 * 
	 * @param map
	 * @return
	 */
	private static String getStrExcludeSign(Map<String, Object> map) {
		Set<String> keySet = map.keySet();

		// 1、剔除sign参数
		List<String> list = new ArrayList<String>();
		for (String key : keySet) {
			if ("sign".equalsIgnoreCase(key) || "callback".equalsIgnoreCase(key)) {
				continue;
			}
			list.add(key);
		}

		// 2、参数排序
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object a, Object b) {
				return a.toString().toLowerCase()
						.compareTo(b.toString().toLowerCase());
			}
		});

		// 3、拼接字符串
		StringBuffer sb = new StringBuffer();
		for (String key : list) {
			sb.append(key);
			
			Object obj = map.get(key);
			if (obj instanceof String[]) {
				String[] params = (String[])map.get(key);
				for (int i = 0; i < params.length; i++) {
					sb.append(params[i]);
				}
			} else {
				String param = (String)map.get(key);
				sb.append(param);
			}
		}

		return sb.toString();
	}
	
	/**
	 * 密码加密
	 * EncryptUtils.getEncryption
	 * <P>Author : DYQ </P>  
	 * <P>Date : 2014年12月25日 </P>
	 *  @param password
	 *  @return
	 *  @throws UnsupportedEncodingException
	 */
	public static String getEncryption(String password) throws UnsupportedEncodingException {
		return MD5Util.md5Hex(password);
	}
}
