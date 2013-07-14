package devopsdistilled.operp.client.main;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel implements Model {
	protected final List<Observer> observers;

	public AbstractModel() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		System.out.println("Observer registered");
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
