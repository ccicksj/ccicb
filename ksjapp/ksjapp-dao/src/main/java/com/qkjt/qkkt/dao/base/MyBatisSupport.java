package com.qkjt.qkkt.dao.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MyBatisSupport {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	protected SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

}
