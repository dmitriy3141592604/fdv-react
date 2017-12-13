package com.github.fdvreact;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.typemarkup.Behavior;

public class InputValueTest extends InputValueTestBase {

	@Test
	@Behavior("По умолчанию значением является null")
	public void test$nullIsDefaultValue() {
		assertEquals(null, value.get());
	}

	@Test
	@Behavior("При установке нового значения, формируется событие")
	public void test$newValueFireUpdateEvent() {

		value.registerUpdateListener(newCallLogAppender("called"));

		assertEquals(" called", callLog());

		value.set("newValue");

		assertEquals(" called called", callLog());
	}

	@Test
	@Behavior("null равен null при сравнении старого и нового значения. Событие не генерируется")
	public void test$nullIsComparableWithNull() {

		value.registerUpdateListener(newCallLogAppender("cl"));

		assertEquals(" cl", callLog());

		value.set(null);

		assertEquals(" cl", callLog());
	}

	@Test
	@Behavior("Событие генерируется только для неравных объектов")
	public void test$eventFiredOnlyForNotEqualsValues() {

		value.set("oldValue");

		value.registerUpdateListener(newCallLogAppender("cl"));

		assertEquals(" cl", callLog());
		assertEquals("oldValue", value.get());

		value.set("newValue");

		assertEquals(" cl cl", callLog());
	}

}
