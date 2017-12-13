package react;

import java.util.Objects;

public abstract class CalculatedValue<ValueType> extends Value<ValueType> implements ValueUpdateListener {

	public abstract ValueType recalculateValue();

	@Override
	public void performUpdate() {
		final ValueType recalculatedVaue = recalculateValue();
		if (Objects.equals(impl, recalculatedVaue)) {
			return;
		}
		impl = recalculatedVaue;
		fireUpdateEvent();
	}
}
