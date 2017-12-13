package com.github.fdvreact;

import java.util.Objects;

public class InputValue<ValueType> extends Value<ValueType> {

	public void set(ValueType newRawValue) {
		if (Objects.equals(cachedValue, newRawValue)) {
			return;
		}
		cachedValue = newRawValue;
		fireUpdateEvent();
	}

}
