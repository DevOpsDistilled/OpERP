package devopsdistilled.operp.client.abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<O extends Observer> implements Model {
	protected final List<O> observers;

	public AbstractModel() {
		observers = new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerObserver(Observer observer) {
		observers.add((O) observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {

	}
}
