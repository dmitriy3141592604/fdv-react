package com.github.fdvreact;

import java.util.Objects;

import com.github.typemarkup.Responsibility;

@Responsibility("Предоставляет шаблон обновления кешированного значения по событию обновления")
public abstract class CalculatedValue<ValueType> extends Value<ValueType> implements ValueUpdateListener {

	/** Точка расширения шаблона обновления кешированного значкния **/
	public abstract ValueType recalculateValue();

	/** Возможно, нужно сделать final **/
	@Override
	public void performUpdate() {
		final ValueType recalculatedVaue = recalculateValue();
		if (Objects.equals(cachedValue, recalculatedVaue)) {
			return;
		}
		cachedValue = recalculatedVaue;
		fireUpdateEvent();
	}
}
