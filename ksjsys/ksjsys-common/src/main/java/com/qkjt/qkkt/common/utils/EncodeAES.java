package com.qkjt.qkkt.common.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class EncodeAES {
    //密钥算法    对称密码   AES
    public static final String ALGORITHM="AES";
    //密钥长度(java默认只能处理128位以内的长度,如果需要处理大于128位可以使用JCE解除密钥长度限制)
    public static final int KEY_SIZE=128;
    /**
     * 生成 密钥
     * @return String Base64编码密钥
     * @throws Exception
     */
    public static String initKeyString() throws Exception{
        return new String(Base64.encodeBase64(initKey()));
    }
    /**
     * 生成密钥
     * @return byte[] 二进制密钥
     * @throws Exception
     */
    private static byte[] initKey() throws Exception{
        //实例化
        KeyGenerator kg=KeyGenerator.getInstance(ALGORITHM);
        //初始化密钥长度
        kg.init(KEY_SIZE);
        //生成秘密密钥
        SecretKey secretKey=kg.generateKey();
        //获得密钥的二进制编码形式
        return secretKey.getEncoded();
    }
    /**
     * 转换密钥
     * @param key 二进制密钥
     * @return Key 密钥
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception{
        //实例化AES密钥材料
        SecretKey secretKey=new SecretKeySpec(key,ALGORITHM);
        return secretKey;
    }
    /**
     * 加密
     * @param data 待加密数据
     * @param key 密钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encode(byte[] data,String key) throws Exception{
        return doEncode(data,getKey(key));
    }
    /**
     * 加密 处理
     * @param data 待加密数据
     * @param key 密钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    private static byte[] doEncode(byte[] data,byte[] key) throws Exception{
        //还原密钥
        Key k=toKey(key);
        //实例化
        Cipher cipher=Cipher.getInstance(ALGORITHM);
        //初始化,设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        //执行操作
        return cipher.doFinal(data);
    }
    /**
     * 解密
     * @param data 待解密数据
     * @param key 密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static String decode(byte[] data,String key) throws Exception{
        return new String(doDecode(data,getKey(key)));
    }
    /**
     * 解密处理
     * @param data 待解密数据
     * @param key 密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    private static byte[] doDecode(byte[] data,byte[] key) throws Exception{
        //还原密钥
        Key k=toKey(key);
        //实例化
        Cipher cipher=Cipher.getInstance(ALGORITHM);
        //初始化,设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);
        //执行操作
        return cipher.doFinal(data);
    }
    /**
     * 获取密钥
     * @param key
     * @return byte[] 密钥
     * @throws Exception
     */
    private static byte[] getKey(String key) throws Exception{
        return Base64.decodeBase64(key.getBytes());
    }
}
