package devopsdistilled.operp.client.abstracts;

public abstract class ImSubTaskPane<C extends SubTaskPaneController> extends
		SubTaskPane {

	protected C controller;

	public void setController(C controller) {
		this.controller = controller;
	}

	public C getController() {
		return controller;
	}

	public void dispose() {

	}
}
