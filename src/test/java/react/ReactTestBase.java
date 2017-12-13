package react;

import org.junit.Before;

public abstract class ReactTestBase {

	protected StringBuilder callLog;

	@Before
	public final void setUpReactTestrBase() {
		callLog = new StringBuilder();
	}

	protected String callLog() {
		return callLog.toString();
	}

	protected ValueUpdateListener newCallLogAppender(String message) {
		return () -> callLog.append(" " + message);
	}

}
