package com.github.fdvreact;

import org.junit.Before;

import com.github.fdvreact.InputValue;

public abstract class InputValueTestBase extends ReactTestBase {

	protected InputValue<String> value;

	@Before
	public void setUpInputValueTestBase() {
		value = new InputValue<String>();
	}

}
