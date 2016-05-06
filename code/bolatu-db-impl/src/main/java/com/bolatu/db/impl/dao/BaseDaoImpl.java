package com.bolatu.db.impl.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.BaseCriteria;
import com.bolatu.db.api.dao.BaseDao;
import com.bolatu.util.ListUtil;
import com.bolatu.util.LogUtil;
import com.bolatu.util.data.PageResult;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.SortDirection;

public abstract class BaseDaoImpl<T, K extends Serializable, C extends BaseCriteria> implements BaseDao<T, K, C> {
	
	protected abstract <R extends CrudRepository<T, K>> R getCrudRepository();
	
	protected abstract MongoOperations getMongoOperations();
	
	protected abstract void preSave(T t);
	
	protected abstract void postSave(T t);
	
	protected abstract void preDelete(T t);
	
	protected abstract void postDelete(T t);
	
	protected abstract Query generateQueryFromCriteria(C criteria);
	
	protected abstract Class<? extends T> getDocumentClass();
	
	protected abstract String getDocumentName();
	
	public T save(T t) throws BolatuDbException {
		try {
			preSave(t);
			getCrudRepository().save(t);
			postSave(t);
			return t;
		} catch (DuplicateKeyException dkEx) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, dkEx);
			throw new BolatuDbException(BolatuDbException.DUPLICATE_KEY_EXCEPTION);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}

	public void delete(T t) throws BolatuDbException {
		try {
			preDelete(t);
			getCrudRepository().delete(t);
			postDelete(t);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}		
	}
	
	public void deleteById(K k) throws BolatuDbException {
		try {
			getCrudRepository().delete(k);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}		
	}
	
	public T findById(K k) throws BolatuDbException {
		try {
			return getCrudRepository().findOne(k);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}
	
	public PageResult<T> findByCriteria(C criteria) throws BolatuDbException {
		try {
			Query query = generateQuery(criteria);			
			
			long total = getMongoOperations().count(query, getDocumentClass(), 
					getDocumentName());			
			List<? extends T> resultList = getMongoOperations().find(query, 
					getDocumentClass(), getDocumentName());
			
			PageResult<T> pageResult;
			if (criteria == null) {
				pageResult = new PageResult<T>(0, 50, total, resultList);				
			} else {
				pageResult = new PageResult<T>(criteria.getPageNumber(), 
						criteria.getPageSize(), total, resultList);
			}			
			return pageResult;
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}
	
	public T findOneByCriteria(C criteria) throws BolatuDbException {
		try {
			return getMongoOperations().findOne(generateQueryFromCriteria(criteria), 
					getDocumentClass(), getDocumentName());
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}
	
	private Query generateQuery(C criteria) {		
		if (criteria == null) {			 
			Query query = new Query();
			query.with(new PageRequest(0, 50));
			return query;
		} else {
			Query query = generateQueryFromCriteria(criteria);
			
			if (criteria.getPageSize() <= 0) {
				criteria.setPageSize(50);
			}
			
			if (criteria.getPageNumber() < 0) {
				criteria.setPageNumber(0);
			}
		
			Pageable pageRequest = new PageRequest(criteria.getPageNumber(), criteria.getPageSize());
			query.with(pageRequest);
			
			if(!ListUtil.isNullOrEmpty(criteria.getSortRequestList())) {
				List<Order> orderList = new ArrayList<Order>();
				for(SortRequest sortRequest : criteria.getSortRequestList()) {
					if(SortDirection.ASC.getDesc().equals(sortRequest.getSortDirection())) {
						orderList.add(new Order(Direction.ASC, sortRequest.getSortField()));
					} else {
						orderList.add(new Order(Direction.DESC, sortRequest.getSortField()));
					}
				}
				query.with(new Sort(orderList));
			}
		
			return query;
		}
	}
	
	protected Query createIsQuery(String fieldName, Object value) {
		Query query = new Query();
		query.addCriteria(Criteria.where(fieldName).is(value));
		
		return query;
	}
	
	protected PageRequest validateAndCreatePageRequest(com.bolatu.util.data.PageRequest request) {
		if (request == null) {
			return new PageRequest(0, 50);
		}
		
		return new PageRequest(request.getPageNumber(), request.getPageSize());
	}
	
}
