package com.bolatu.db.api.dao;

import java.io.Serializable;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.BaseCriteria;
import com.bolatu.util.data.PageResult;

public interface BaseDao<T, K extends Serializable, C extends BaseCriteria> {
	
	public T save(T t) throws BolatuDbException;
	
	public void delete(T t) throws BolatuDbException;
	
	public void deleteById(K k) throws BolatuDbException;
	
	public T findById(K k) throws BolatuDbException;
	
	public PageResult<T> findByCriteria(C criteria) throws BolatuDbException;
	
	public T findOneByCriteria(C criteria) throws BolatuDbException;
	
}
