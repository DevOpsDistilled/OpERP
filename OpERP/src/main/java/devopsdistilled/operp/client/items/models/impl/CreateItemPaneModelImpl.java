package devopsdistilled.operp.client.items.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.models.observers.CreateItemPaneModelObserver;

public class CreateItemPaneModelImpl extends
		AbstractPaneModel<CreateItemPaneModelObserver> implements
		CreateItemPaneModel {

	private String title = "Create Item";

	@Override
	public void setTitle(String title) {
		this.title = title;

		for (CreateItemPaneModelObserver observer : observers) {
			observer.updateTitle(this.title);
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

}
