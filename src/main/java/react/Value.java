package react;

import java.util.ArrayList;
import java.util.List;

import com.github.typemarkup.Responsibility;

/** TODO Необходим механизм удаления наблюдателей. **/
/** TODO Один наблюдатель должен регистрироваться только один раз. **/
/** TODO Нужен механизм идентификации значения (метод name) **/
/** TODO Для создания производных классов должна использоваться фабрика **/
@Responsibility("Обеспечивает жизненный цикл обновляемого по событию значения")
public abstract class Value<ValueType> {

	/** Закешированное значение. */
	protected ValueType cachedValue;

	/**
	 * Список наблюдателей, которые хотят реагировать на факт измененеия
	 * кешированного значения.
	 */
	private final List<ValueUpdateListener> listeners = new ArrayList<ValueUpdateListener>();

	/**
	 * Обеспечивает доступ к закешированному значению.
	 *
	 * @return Возвращает хранимое в контейнере значение
	 */
	public ValueType get() {
		return cachedValue;
	}

	/**
	 * Регистрирует наблюдателя
	 *
	 * @param listener
	 *            - Новый наблюдатель
	 */
	public void registerUpdateListener(ValueUpdateListener listener) {
		listeners.add(listener);
		fireUpdateEvent();
	}

	/** Оповещает наблюдателей об изменении закешированного значения **/
	protected void fireUpdateEvent() {
		listeners.forEach((listener) -> listener.performUpdate());
	}

}
