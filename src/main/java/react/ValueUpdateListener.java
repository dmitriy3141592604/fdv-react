package react;

import com.github.typemarkup.Responsibility;

@Responsibility("Инкапсулирует факт изменения значения в источнике данных для вычислений")
public interface ValueUpdateListener {

	public void performUpdate();
}
