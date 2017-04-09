package com.qkjt.qkkt.dao.demo;

import java.util.HashMap;
import java.util.List;

import com.qkjt.qkkt.domain.beans.Test;

/**
 * 用户DAO接口
 * @author wangxilu
 * @date 2014/12/12
 */
public interface TestDao {
    /**
     * 新增用户基本信息的方法
     * @param test 用户基本信息对象
     * @return Integer 返回成功或失败
     */
    Integer insert(Test test);

    /**
     * 修改用户基本信息的方法
     * @param test 用户基本信息对象
     * @return Integer 返回成功或失败
     */
    Integer update(Test test);

    /**
     * 根据Id查询用户基本信息的方法
     * @param id 用户ID
     * @return Test 用户基本信息对象
     */
    Test findById(Integer id);

    /**
     * 查询用户基本信息的方法
     * @param map map集合
     * @return Integer 成功或失败
     */
    Integer findListCount(HashMap<String, Object> map);

    /**
     * 分页查询用户基本信息的方法
     * @param map map集合
     * @return List<Test> 用户基本信息List对象
     */
    List<Test> findList(HashMap<String, Object> map);

    /**
     * 删除用户基本信息的方法
     * @param id 用户ID
     * @return Integer 成功或失败
     */
    Integer delete(Integer id);


}
