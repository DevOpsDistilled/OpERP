package devopsdistilled.operp.client.abstracts;

public interface Model {
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}
