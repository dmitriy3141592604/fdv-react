package com.github.fdvreact;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.typemarkup.Behavior;

public class CalculatedValueTest extends CalculatedValueTestBase {

	@Test
	@Behavior("Значение поля вычисляется при обновлении источников данных")
	public void test$valueRecalculatedByEvent() {

		value = newCalculatedValue("recalculated", "newValue");

		assertEquals("", callLog());

		value.performUpdate();

		assertEquals("recalculated", callLog());
	}

	@Test
	@Behavior("Если значение равно предыдущему, то событие обновления не посылается дальше")
	public void test$noPropogationIfNewValueEqualToOldValue() {

		value = newCalculatedValue(" recalculated", null);
		value.registerUpdateListener(newCallLogAppender("propogaded"));

		assertEquals(null, value.get());
		assertEquals(" propogaded", callLog());

		value.performUpdate();

		assertEquals(" propogaded recalculated", callLog());
	}

	@Test
	@Behavior("Если вычисляется значение отличное от старого, то генерируется событие")
	public void test$generateEventIfNewVaulueIsNotEqualToOldValue() {

		value = newCalculatedValue(" recalculated", "newValue");
		value.registerUpdateListener(newCallLogAppender("observers notified"));

		assertEquals(" observers notified", callLog());

		value.performUpdate();

		assertEquals("newValue", value.get());
		assertEquals(" observers notified recalculated observers notified", callLog());
	}
}
