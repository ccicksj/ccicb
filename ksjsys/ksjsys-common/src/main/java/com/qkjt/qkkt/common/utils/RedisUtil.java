package com.qkjt.qkkt.common.utils;


import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * redis工具类
 *
 * @author liubaoyu
 * @date 2015年4月2日 下午5:46:38
 */
@Component
public class RedisUtil implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private static ShardedJedisPool shardedJedisPool;

    // set方法成功标记
    private static final String SUCCESS = "OK";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        shardedJedisPool = (ShardedJedisPool) applicationContext.getBean("shardedJedisPool");
    }

    private static void returnResource(ShardedJedis shardedJedis) {
        if (null != shardedJedisPool) {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 添加string
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setString(String key, String value) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            String result = shardedJedis.set(key, value);
            if (null != result && result.equals(SUCCESS)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.error("Set string error!", e);
            return false;
        } finally {
            returnResource(shardedJedis);
        }
    }

    /**
     * 添加string，并设置过期时间
     *
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public static boolean setString(String key, int seconds, String value) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();

            String result = shardedJedis.setex(key, seconds, value);
            if (null != result && result.equals(SUCCESS)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.error("Set string expire error!", e);
            return false;
        } finally {
            returnResource(shardedJedis);
        }
    }

    /**
     * 获取string
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.get(key);
        } catch (Exception e) {
            LOGGER.error("Get string error!", e);
            return null;
        } finally {
            returnResource(shardedJedis);
        }
    }

    /**
     * 添加bean
     *
     * @param key
     * @param bean
     * @return
     */
    public static boolean setBean(String key, Object bean) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            Gson gson = new Gson();
            String result = shardedJedis.set(key, gson.toJson(bean));
            if (null != result && result.equals(SUCCESS)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.error("Set bean error!", e);
            return false;
        } finally {
            returnResource(shardedJedis);
        }
    }

    /**
     * 添加bean，并设置过期时间
     *
     * @param key
     * @param bean
     * @return
     */
    public static boolean setBean(String key, int seconds, Object bean) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            Gson gson = new Gson();
            String result = shardedJedis.setex(key, seconds, gson.toJson(bean));
            if (null != result && result.equals(SUCCESS)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.error("Set bean expire error!", e);
            return false;
        } finally {
            returnResource(shardedJedis);
        }
    }

    /**
     * 获取bean
     *
     * @param key
     * @param clazz
     * @return
     */
    public static <T> T getBean(String key, Class<T> clazz) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            String value = shardedJedis.get(key);
            Gson gson = new Gson();
            if (null != value) {
                return gson.fromJson(value, clazz);
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Get bean error!", e);
            return null;
        } finally {
            returnResource(shardedJedis);
        }
    }

    /**
     * 添加beans
     *
     * @param key
     * @param bean
     * @return
     */
    public static boolean setBeans(String key, List beans) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            Gson gson = new Gson();
            String result = shardedJedis.set(key, gson.toJson(beans));
            if (null != result && result.equals(SUCCESS)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.error("Set beans error!", e);
            return false;
        } finally {
            returnResource(shardedJedis);
        }
    }


    /**
     * 获取beans
     *
     * @param key
     * @param type 例: Type type = new TypeToken<List<User>>(){}.getType();
     * @return
     */
    public static <T> List<T> getBeans(String key, Type type) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            String value = shardedJedis.get(key);
            if (null != value) {
                Gson gson = new Gson();
                return gson.fromJson(value, type);
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Get beans error!", e);
            return null;
        } finally {
            returnResource(shardedJedis);
        }
    }


}
