package react;

import org.junit.Before;

public abstract class InputValueTestBase extends ReactTestBase {

	protected InputValue<String> value;

	@Before
	public void setUpInputValueTestBase() {
		value = new InputValue<String>();
	}

}
