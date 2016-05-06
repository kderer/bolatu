package com.bolatu.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {	
	
	public static <T, S extends T> List<T> convertImpList(List<S> list) {
		List<T> returnList = new ArrayList<T>();
		
		if(list != null) {
			for(S obj : list) {
				returnList.add(obj);
			}
		}
		
		return returnList;
	}
	
	public static <T> boolean isNullOrEmpty(List<T> list) {
		if (list == null) {
			return true;
		}
		
		if (list.size() > 0) {
			return false;
		}
		
		return true;
	}

}
