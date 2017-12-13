package react;

import java.util.ArrayList;
import java.util.List;

public abstract class Value<ValueType> {

	protected ValueType impl;

	private final List<ValueUpdateListener> listeners = new ArrayList<ValueUpdateListener>();

	public ValueType get() {
		return impl;
	}

	public void registerUpdateListener(ValueUpdateListener listener) {
		listeners.add(listener);
		fireUpdateEvent();
	}

	protected void fireUpdateEvent() {
		listeners.forEach((listener) -> listener.performUpdate());
	}

}