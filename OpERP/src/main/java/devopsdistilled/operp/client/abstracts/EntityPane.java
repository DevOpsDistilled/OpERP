package devopsdistilled.operp.client.abstracts;

public abstract class EntityPane<C extends EntityPaneController<?, ?, ?>>
		extends SubTaskPane {

	protected C controller;

	public void setController(C controller) {
		this.controller = controller;
	}

	public C getController() {
		return controller;
	}

	public void dispose() {
		resetComponents();
		getDialog().dispose();
	}

	public abstract void resetComponents();
}
