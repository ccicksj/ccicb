package com.qkjt.qkkt.dao.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qkjt.qkkt.dao.base.BaseDaoImpl;
import com.qkjt.qkkt.domain.beans.Test;

/**
 * 用户DAO接口实现类
 * @author wangxilu
 * @date 2014/12/12
 */
@SuppressWarnings("unchecked")
@Repository
public class TestDaoImpl extends BaseDaoImpl<Test, String> implements TestDao {
    @Override
    public String getNameSpace() {
        return "sqlmap.Test";
    }

    @Override
    public Integer insert(Test test) {
        return insert(getStatement(INSERT), test);
    }

    @Override
    public Integer update(Test test) {
        return update(getStatement(UPDATE), test);
    }

    @Override
    public Test findById(Integer id) {
        return selectOne(getStatement(FINDBYID), id);
    }

    @Override
    public Integer findListCount(HashMap<String, Object> map) {
        return ((Number) selectOne(getStatement(FINDLISTCOUNT), map)).intValue();
    }

    @Override
    public List<Test> findList(HashMap<String, Object> map) {
        return selectList(getStatement(FINDLIST), map);
    }

    @Override
    public Integer delete(Integer id) {
        return delete(getStatement(DELETE), id);
    }

}
