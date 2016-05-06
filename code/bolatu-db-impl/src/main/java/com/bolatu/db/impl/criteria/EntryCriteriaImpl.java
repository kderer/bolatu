package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bolatu.db.api.criteria.EntryCriteria;
import com.bolatu.db.api.criteria.ValueInterval;

public class EntryCriteriaImpl extends BaseCriteriaImpl implements EntryCriteria {
	private List<String> entryIdList;
	private ValueInterval<Integer> sourceAgeInterval;
	private List<String> sourceGenderList;
	private List<Character> targetAgeRangeList;
	private List<String> targetGenderList;
	private List<String> ipList;
	private List<String> tagList;
	private ValueInterval<Date> postDateInterval;
	private List<Character> statusList;
	private List<String> usernameList;
	
	public List<String> getEntryIdList() {
		return entryIdList;
	}

	public void setEntryIdList(List<String> entryIdList) {
		this.entryIdList = entryIdList;
	}

	public ValueInterval<Integer> getSourceAgeInterval() {
		return sourceAgeInterval;
	}

	public void setSourceAgeInterval(ValueInterval<Integer> sourceAgeInterval) {
		this.sourceAgeInterval = sourceAgeInterval;
	}

	public List<String> getSourceGenderList() {
		return sourceGenderList;
	}


	public void setSourceGenderList(List<String> sourceGenderList) {
		this.sourceGenderList = sourceGenderList;
	}

	public List<Character> getTargetAgeRangeList() {
		return targetAgeRangeList;
	}

	public void setTargetAgeRangeList(List<Character> targetAgeRangeList) {
		this.targetAgeRangeList = targetAgeRangeList;
	}

	public List<String> getTargetGenderList() {
		return targetGenderList;
	}

	public void setTargetGenderList(List<String> targetGenderList) {
		this.targetGenderList = targetGenderList;
	}

	public List<String> getIpList() {
		return ipList;
	}

	public void setIpList(List<String> ipList) {
		this.ipList = ipList;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public ValueInterval<Date> getPostDateInterval() {
		return postDateInterval;
	}

	public void setPostDateInterval(ValueInterval<Date> postDateInterval) {
		this.postDateInterval = postDateInterval;
	}

	public List<Character> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Character> statusList) {
		this.statusList = statusList;
	}
	
	@Override
	public void addStatus(Character status) {
		if (statusList == null) {
			statusList = new ArrayList<Character>();
		}
		statusList.add(status);
	}

	@Override
	public void resetCriteria() {
		
	}

	@Override
	public void addEntryId(String entryId) {
		if (entryIdList == null) {
			entryIdList = new ArrayList<String>();
		}
		entryIdList.add(entryId);
	}

	@Override
	public void addSourceGender(String sourceGender) {
		if (sourceGenderList == null) {
			sourceGenderList = new ArrayList<String>();
		}
		sourceGenderList.add(sourceGender);
	}

	@Override
	public void addTargetAgeRange(Character targetAgeRange) {
		if (targetAgeRangeList == null) {
			targetAgeRangeList = new ArrayList<Character>();
		}
		targetAgeRangeList.add(targetAgeRange);
	}

	@Override
	public void addTargetGender(String targetGender) {
		if (targetGenderList == null) {
			targetGenderList = new ArrayList<String>();
		}
		targetGenderList.add(targetGender);
	}

	@Override
	public void addIp(String ip) {
		if (ipList == null) {
			ipList = new ArrayList<String>();
		}
		ipList.add(ip);
	}

	@Override
	public void addTag(String tag) {
		if (tagList == null) {
			tagList = new ArrayList<String>();
		}
		tagList.add(tag);
	}

	@Override
	public void addUserName(String username) {
		if (usernameList == null) {
			usernameList = new ArrayList<String>();
		}
		usernameList.add(username);
	}

	@Override
	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}

	@Override
	public List<String> getUsernameList() {
		return usernameList;
	}
	
}
