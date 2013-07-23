package devopsdistilled.operp.client.abstracts;

public interface Model<O extends Observer> {
	public void registerObserver(O observer);

	public void removeObserver(O observer);

	public void notifyObservers();
}
