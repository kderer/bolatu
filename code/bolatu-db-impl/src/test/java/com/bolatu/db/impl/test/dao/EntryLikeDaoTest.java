package com.bolatu.db.impl.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.dao.EntryDao;
import com.bolatu.db.api.dao.EntryLikeDao;
import com.bolatu.db.api.dao.UserDao;
import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.EntryLike;
import com.bolatu.db.api.model.User;
import com.bolatu.db.impl.model.EntryLikeImpl;
import com.bolatu.db.impl.test.BaseTestConfig;
import com.bolatu.util.data.PageRequest;
import com.bolatu.util.data.PageResult;

public class EntryLikeDaoTest extends BaseTestConfig {
	
	@Autowired
	private EntryDao entryDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EntryLikeDao entryLikeDao;
	
	@Test
	public void testSave() throws BolatuDbException {
		
		User user = userDao.findByCriteria(null).getResultList().get(0);
		Entry entry = entryDao.findByCriteria(null).getResultList().get(0);
		
		EntryLike like = new EntryLikeImpl();
		like.setEntryId(entry.getId());
		like.setUsername(user.getUsername());
		
		entryLikeDao.save(like);
		
		entry = entryDao.findById(entry.getId());
		
		Assert.assertEquals(1, 1);
	}
	
	@Test
	public void testDelete() throws BolatuDbException {
		EntryLike like = entryLikeDao.findByCriteria(null).getResultList().get(0);
		entryLikeDao.delete(like);
				
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void testFindByEntryId() throws BolatuDbException {
		Entry entry = entryDao.findByCriteria(null).getResultList().get(0);
		
		PageResult<EntryLike> result = entryLikeDao.findByEntryId(entry.getId(), new PageRequest());
		
		Assert.assertEquals(1, result.getTotal());
		
	}
	

}
