package com.bolatu.db.impl.test.dao;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.EntryCriteria;
import com.bolatu.db.api.dao.EntryDao;
import com.bolatu.db.api.dao.UserDao;
import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.User;
import com.bolatu.db.impl.criteria.EntryCriteriaImpl;
import com.bolatu.db.impl.model.EntryImpl;
import com.bolatu.db.impl.test.BaseTestConfig;
import com.bolatu.util.data.PageResult;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.AgeRange;
import com.bolatu.util.enumaration.EntryStatus;
import com.bolatu.util.enumaration.Gender;
import com.bolatu.util.enumaration.SortDirection;

public class EntryDaoTest extends BaseTestConfig {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EntryDao entryDao;	
	
	@Test
	public void testSave() throws BolatuDbException {
		User user = userDao.findByUsername("abaza6931");
		
		Entry entry = new EntryImpl();
		entry.setIp("112.16.94.153");
		entry.setPostDate(Calendar.getInstance().getTime());
		entry.setStatus(EntryStatus.APPROVED.getCode());
		entry.setTags("am got meme");
		entry.setTargetAgeRange(AgeRange.F30T40.getCode());
		entry.setTargetGender(Gender.GAY.getCode());
		entry.setText("我今天看到一个长头发大鼻子男人。很喜欢他");
		entry.setTitle("My Gay Love");
		entry.setUser(user);
		
		entryDao.save(entry);
		
	}
	
	@Test
	public void testFindByCriteria() throws BolatuDbException {
		EntryCriteria criteria = new EntryCriteriaImpl();
		criteria.addUserName("abaza31");
		criteria.setPageSize(100);
		
		PageResult<Entry> entryList = entryDao.findByCriteria(criteria);
		
		Assert.assertNotEquals(entryList.getResultList().size(),
				entryDao.findByCriteria(null).getResultList().size());		
	}
	
	@Test
	public void testDelete() throws BolatuDbException {
		PageResult<Entry> entryList = entryDao.findByCriteria(null);
		
		for (Entry entry : entryList.getResultList()) {
			entryDao.delete(entry);
		}
	}
	
	@Test
	public void testUpdate() throws BolatuDbException {
		Entry entry = entryDao.findByCriteria(null).getResultList().get(0);
		entryDao.save(entry);		
	}
	
	@Test 
	public void testUpdateStatus() throws BolatuDbException {
		Entry entry = entryDao.findByCriteria(null).getResultList().get(0);
		
		entryDao.delete(entry);
		entryDao.save(entry);
		
		entryDao.updateStatus(entry.getId(), EntryStatus.REJECTED);
	}
	
	@Test 
	public void testSaveLike() throws BolatuDbException {
		Entry entry = entryDao.findByCriteria(null).getResultList().get(0);
		
		System.out.println(entry.getLikedUserList().size());
		
		entryDao.saveLike(entry.getId(), "osman1");		
	}
	
	@Test
	public void testFindMostLiked() throws BolatuDbException {
		EntryCriteria criteria = new EntryCriteriaImpl();
		criteria.addStatus(EntryStatus.REJECTED.getCode());
		criteria.addSortRequest(new SortRequest("likedUserList.size", SortDirection.DESC));
		
		PageResult<Entry> entryList = entryDao.findByCriteria(criteria);
		
		Assert.assertNotEquals(0, entryList.getResultList().size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void batchUpdateStatus() throws Exception {
		EntryCriteria criteria = new EntryCriteriaImpl();
		criteria.setPageSize(200);
		List<EntryImpl> entryList = (List<EntryImpl>) entryDao.findByCriteria(criteria).getResultList();
		
		for (Entry entry : entryList) {
			entryDao.updateStatus(entry.getId(), EntryStatus.APPROVED);
		}
	}
	
}