package devopsdistilled.operp.client.abstracts;

public abstract class AbstractPaneModel<PO extends PaneModelObserver> extends
		AbstractModel<PO> implements PaneModel<PO> {

	protected String title;

	@Override
	public void update() {
		setTitle(getTitle());
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
		for (PaneModelObserver observer : observers) {
			observer.updateTitle(this.title);
		}
	}

}
