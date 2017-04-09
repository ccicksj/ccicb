package com.qkjt.qkkt.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qkjt.qkkt.common.utils.Page;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.session.RowBounds;


public abstract class BaseDaoImpl<T, KEY extends Serializable> extends
		MyBatisSupport implements BaseDao<T, KEY> {

	public static final String INSERT = "insert";
	public static final String DELETE = "delete";
	public static final String UPDATE = "update";
	public static final String FINDBYID = "findById";
	public static final String FINDLISTCOUNT = "findListCount";
	public static final String FINDLIST= "findList";

	/**
	 * 获取命名空前前缀
	 * 
	 * @return
	 */
	public abstract String getNameSpace();

	public String getStatement(String sql) {
		return getNameSpace() + "." + sql;
	};

	@Override
	public int insert(String statement, Object parameter) {
		return getSqlSessionTemplate().insert(statement, parameter);
	}

	@Override
	public int delete(String statement, Object parameter) {
		return getSqlSessionTemplate().delete(statement, parameter);
	}

	@Override
	public int update(String statement, Object parameter) {
		return getSqlSessionTemplate().update(statement, parameter);
	}

	@Override
	public T selectOne(String statement) {
		return (T) getSqlSessionTemplate().selectOne(statement);
	}

	@Override
	public <T> T selectOne(String statement, Object parameter) {
		return (T) getSqlSessionTemplate().selectOne(statement, parameter);
	}

	@Override
	public List<T> selectList(String statement) {
		return (List<T>) getSqlSessionTemplate().selectList(statement);
	}

	@Override
	public <T> List<T> selectList(String statement, Object parameter) {
		return (List<T>) getSqlSessionTemplate().selectList(statement,
				parameter);
	}

	private Map<String, Integer> toParameterMap(Object parameter, Page p) {
		Map<String, Integer> map = (Map<String, Integer>) toParameterMap(parameter);
		map.put("startRow", p.getFirst());
		map.put("endRow", p.getFirst() + p.getPageSize() - 1);
		map.put("offset", p.getFirst() - 1);
		map.put("limit", p.getPageSize());
		return map;
	}

	private Map<?, ?> toParameterMap(Object parameter) {
		if (parameter == null) {
			return new HashMap<Object, Object>();
		}
		if (parameter instanceof Map) {
			return (Map<?, ?>) parameter;
		} else {
			try {
				return PropertyUtils.describe(parameter);
			} catch (Exception e) {
				return null;
			}
		}
	}

	public Page<T> findPage(final Page<T> page, final Map<String, Object> filter) {
		long totalCount = ((Number) getSqlSessionTemplate().selectOne(
				getStatement(""), filter)).longValue();
		page.setTotalCount(totalCount);

		Map<String, Integer> parameter = toParameterMap(filter, page);
		RowBounds rowBounds = getRowBounds(page);
		List<T> result = getSqlSessionTemplate().selectList(getStatement(""),
				parameter, rowBounds);
		if (result == null) {
			result = new ArrayList<T>();
		}
		page.setResult(result);
		return page;
	}

	private RowBounds getRowBounds(Page<?> p) {
		return new RowBounds(p.getFirst() - 1, p.getPageSize());
	}
}
