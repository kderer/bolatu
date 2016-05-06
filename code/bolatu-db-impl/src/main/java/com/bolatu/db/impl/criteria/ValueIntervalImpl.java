package com.bolatu.db.impl.criteria;

import com.bolatu.db.api.criteria.ValueInterval;

public class ValueIntervalImpl<T> implements ValueInterval<T> {

	private T startValue;
	private T endValue;
	
	public ValueIntervalImpl(T startValue, T endValue) {
		this.startValue = startValue;
		this.endValue = endValue;
	}
	
	@Override
	public T getStartValue() {
		return startValue;
	}

	@Override
	public T getEndValue() {
		return endValue;
	}

}
