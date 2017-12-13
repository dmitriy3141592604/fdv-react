package react;

import com.github.typemarkup.Responsibility;

/**
 * Предоставляет контракт обновления зависимых значений для наблюдателя.
 *
 * @author dmitriy3141592604
 *
 */
@Responsibility("Инкапсулирует факт изменения значения в источнике данных для вычислений")
public interface ValueUpdateListener {

	public void performUpdate();

}
