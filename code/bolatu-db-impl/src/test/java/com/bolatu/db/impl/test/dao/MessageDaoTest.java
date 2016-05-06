package com.bolatu.db.impl.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.MessageCriteria;
import com.bolatu.db.api.dao.MessageDao;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.impl.criteria.MessageCriteriaImpl;
import com.bolatu.db.impl.model.MessageImpl;
import com.bolatu.db.impl.test.BaseTestConfig;
import com.bolatu.util.enumaration.YesNo;

public class MessageDaoTest extends BaseTestConfig {
	
	@Autowired
	private MessageDao messageDao;
	
	@Test
	public void testSave() throws BolatuDbException {
		Message message = new MessageImpl();
		
		message.setSender("kadir");
		message.setReceiver("deniz");
		message.setTitle("denizin gotu");
		message.setContent("sikmek istiyom");
		
		messageDao.save(message);
		
		Assert.assertNotNull(message);
	}
	
	@Test
	public void testFindOneByCriteria() throws BolatuDbException {
		MessageCriteria criteria = new MessageCriteriaImpl();
		
		criteria.addMessageTitle("denizin gotu");
		
		Assert.assertNotNull(messageDao.findOneByCriteria(criteria));
	}
	
	@Test
	public void testFindByCriteria() throws BolatuDbException {
		MessageCriteria criteria = new MessageCriteriaImpl();
		
		criteria.addMessageTitle("denizin gotu");
		
		Assert.assertNotEquals(0, messageDao.findByCriteria(criteria).getResultList().size());
	}	
	
	@Test
	public void testDeleteFromInbox() throws BolatuDbException {
		MessageCriteria criteria = new MessageCriteriaImpl();
		
		Message message = messageDao.findByCriteria(criteria).getResultList().get(1);
		
		messageDao.deleteFromInbox(message.getId(), message.getReceiver());
		
		Assert.assertEquals(YesNo.YES.getCode(), messageDao.findById(message.getId()).getDeletedFromInbox());
	}
	
	@Test
	public void testDeleteFromSent() throws BolatuDbException {
		MessageCriteria criteria = new MessageCriteriaImpl();
		
		Message message = messageDao.findByCriteria(criteria).getResultList().get(0);
		
		messageDao.deleteFromSent(message.getId(), message.getSender());
		
		Assert.assertEquals(YesNo.YES.getCode(), messageDao.findById(message.getId()).getDeletedFromSent());
	}	

}
