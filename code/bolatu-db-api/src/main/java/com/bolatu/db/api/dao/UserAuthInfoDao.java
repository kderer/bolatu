package com.bolatu.db.api.dao;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.BaseCriteria;
import com.bolatu.db.api.model.UserAuthInfo;

public interface UserAuthInfoDao extends BaseDao<UserAuthInfo, String, BaseCriteria> {
	
	public UserAuthInfo findByUsername(String username) throws BolatuDbException;
	
	public void updateLastLogin(String username, String lastLoginIp, char lastLoginSite) throws BolatuDbException;

}
