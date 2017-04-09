package com.qkjt.qkkt.service.test;


import javax.annotation.Resource;




import com.qkjt.qkkt.dao.demo.TestDao;
import com.qkjt.qkkt.domain.beans.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 用户Service接口实现类
 * 
 * @author wangxilu
 * @date 2014/12/12
 */
@Service
public class TestServiceImpl implements TestService {
    private static final Logger log = LoggerFactory.getLogger(Test.class);
    
    /**
     * 用户基本信息数据访问类
     */
    @Resource
    private TestDao testDao;

    @Override
    public Integer insert(Test test) {
        return testDao.insert(test);
    }

    @Override
    public Integer update(Test test) {
        return testDao.update(test);
    }

    @Override
    public Integer delete(Integer id) {
        return testDao.delete(id);
    }

    @Override
    public List<Test> findList(HashMap<String, Object> map) {
        return testDao.findList(map);
    }

    @Override
    public Integer findListCount(HashMap<String, Object> map) {
        return testDao.findListCount(map);
    }

    @Override
    public Test findById(Integer id) {
        return testDao.findById(id);
    }
}
