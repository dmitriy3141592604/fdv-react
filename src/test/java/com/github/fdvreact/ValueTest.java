package com.github.fdvreact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.github.fdvreact.Value;
import com.github.typemarkup.Behavior;

public class ValueTest extends ValueTestBase {

	@Test
	@Behavior("При регистрации нового наблюдателя возникает событие обновления")
	public void test$listenerRegistrationFireUpdateEvent() {
		value = new Value<String>() {

			@Override
			protected void fireUpdateEvent() {
				super.fireUpdateEvent();
				callLog.append(" event fired");
			}

		};

		assertEquals("", callLog());

		value.registerUpdateListener(newCallLogAppender("new listener called"));

		assertEquals(" new listener called event fired", callLog());

	}

	@Test
	@Ignore
	@Behavior("При регистрации нового наблюдателя возникает событие обновления,только если значение изменилось")
	public void test$fireOnlyIfNotEqualValue() {
		fail("");
	}
}
