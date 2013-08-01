package devopsdistilled.operp.client.abstracts;

public abstract class AbstractPaneModel<PO extends PaneModelObserver> extends
		AbstractModel<PO> implements PaneModel<PO> {

	@Override
	public void update() {
		setTitle(getTitle());
	}

	@Override
	public void setTitle(String title) {
		for (PO observer : observers) {
			observer.updateTitle(title);
		}
	}

}
