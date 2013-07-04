package devopsdistilled.operp.client.view;

public abstract class ViewPane {

	protected Listener listener;

	public Controller getController() {
		return getListener().getController();
	}

	private Listener getListener() {
		return listener;
	}
}
