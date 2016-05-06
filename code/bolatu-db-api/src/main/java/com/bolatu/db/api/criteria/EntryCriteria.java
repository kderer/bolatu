package com.bolatu.db.api.criteria;

import java.util.Date;
import java.util.List;

public interface EntryCriteria extends BaseCriteria {
	
	public List<String> getEntryIdList();
	public void setEntryIdList(List<String> entryIdList);
	public void addEntryId(String entryId);

	public void setSourceAgeInterval(ValueInterval<Integer> sourceAgeInterval);
	public ValueInterval<Integer> getSourceAgeInterval();

	public List<String> getSourceGenderList();
	public void setSourceGenderList(List<String> sourceGenderList);
	public void addSourceGender(String sourceGender);

	public List<Character> getTargetAgeRangeList();
	public void setTargetAgeRangeList(List<Character> targetAgeRangeList);
	public void addTargetAgeRange(Character targetAgeRage);

	public List<String> getTargetGenderList();
	public void setTargetGenderList(List<String> targetGenderList);
	public void addTargetGender(String targetGender);

	public List<String> getIpList();
	public void setIpList(List<String> ipList);
	public void addIp(String ip);

	public List<String> getTagList();
	public void setTagList(List<String> tagList);
	public void addTag(String tag);

	public ValueInterval<Date> getPostDateInterval();
	public void setPostDateInterval(ValueInterval<Date> postDateInterval);
	
	public List<Character> getStatusList();
	public void setStatusList(List<Character> statusList);
	public void addStatus(Character status);
	
	public void addUserName(String username);
	public void setUsernameList(List<String> usernameList);
	public List<String> getUsernameList();

}
