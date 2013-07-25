package devopsdistilled.operp.client.abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<O extends Observer> implements Model<O> {
	protected final List<O> observers;

	public AbstractModel() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(O observer) {
		observers.add(observer);
		update();
	}

	@Override
	public void removeObserver(O observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {

	}

}
