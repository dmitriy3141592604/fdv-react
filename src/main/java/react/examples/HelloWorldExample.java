package react.examples;

import react.CalculatedValue;
import react.InputValue;
import react.Value;

/**
 * Пример формирования строки Hello, World.
 *
 * @author dmitriy3141592604
 *
 */
public class HelloWorldExample implements Runnable, HelloWorldExampleSupportLibrary {

	public static void main(String... args) {
		new HelloWorldExample().run();
	}

	// XXX Удалить предупреждение
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		final InputValue<String> hello = new InputValue<String>();
		final InputValue<String> world = new InputValue<String>();
		final InputValue<String> exclamation = new InputValue<String>();
		final InputValue<String> space = new InputValue<String>();

		final Value<String> helloWorld = summ(hello, space, world, exclamation);

		print("До инициализации значений : " + helloWorld.get());

		hello.set("hello");
		world.set("world");
		exclamation.set("!");
		space.set(" ");

		print("После инициализации       : " + helloWorld.get());

		hello.set("Hello");
		world.set("World");

		print("После исправления ошибок  : " + helloWorld.get());

	}

	private void print(String string) {
		System.out.println(string);

	}

}

/**
 * Пример формирования функцй для работы с кешированными значениями
 *
 * @author dmitriy3141592604
 *
 */
interface HelloWorldExampleSupportLibrary {

	// TODO Удалить предупреждение
	public default Value<String> summ(Value<String> left, @SuppressWarnings("unchecked") Value<String>... rest) {
		final CalculatedValue<String> retVal = new CalculatedValue<String>() {

			@Override
			public String recalculateValue() {
				final StringBuilder retVal = new StringBuilder();
				retVal.append(left.get());
				for (final Value<String> v : rest) {
					retVal.append(v.get());
				}
				return retVal.toString();
			};
		};

		left.registerUpdateListener(retVal);

		for (final Value<String> v : rest) {
			v.registerUpdateListener(retVal);
		}
		return retVal;

	}
}
