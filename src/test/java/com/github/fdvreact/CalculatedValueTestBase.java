package com.github.fdvreact;

import org.junit.Before;

import com.github.fdvreact.CalculatedValue;

public abstract class CalculatedValueTestBase extends ReactTestBase {

	protected CalculatedValue<String> value;

	@Before
	public final void setUpCalculatedValueTestBase() {
	}

	protected CalculatedValue<String> newCalculatedValue(String recalculationLogMessage, String recalculatedValue) {
		return new CalculatedValue<String>() {

			@Override
			public String recalculateValue() {
				callLog.append(recalculationLogMessage);
				return recalculatedValue;
			}

		};
	}

}
