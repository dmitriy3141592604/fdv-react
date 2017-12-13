package react;

import java.util.Objects;

public class InputValue<ValueType> extends Value<ValueType> {

	public void set(ValueType newRawValue) {
		if (Objects.equals(impl, newRawValue)) {
			return;
		}
		impl = newRawValue;
		fireUpdateEvent();
	}

}
