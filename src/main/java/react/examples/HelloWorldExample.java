package react.examples;

import react.CalculatedValue;
import react.InputValue;
import react.Value;

public class HelloWorldExample implements Runnable {

	public static void main(String... args) {
		new HelloWorldExample().run();
	}

	@Override
	public void run() {
		final InputValue<String> hello = new InputValue<String>();
		final InputValue<String> world = new InputValue<String>();
		final InputValue<String> exclamation = new InputValue<String>();
		final InputValue<String> space = new InputValue<String>();

		final Value<String> helloWorld = summ(summ(hello, summ(space, world)), exclamation);

		print("До инициализации значений: " + helloWorld.get());

		hello.set("hello");
		world.set("world");
		exclamation.set("!");
		space.set(" ");

		print("После инициализации: " + helloWorld.get());

		hello.set("Hello");
		world.set("World");

		print("После исправления ошибок: " + helloWorld.get());

	}

	private void print(String string) {
		System.out.println(string);

	}

	public Value<String> summ(Value<String> left, Value<String>... rest) {
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
