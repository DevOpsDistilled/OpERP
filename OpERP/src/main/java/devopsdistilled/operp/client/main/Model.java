package devopsdistilled.operp.client.main;

public interface Model {
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}
