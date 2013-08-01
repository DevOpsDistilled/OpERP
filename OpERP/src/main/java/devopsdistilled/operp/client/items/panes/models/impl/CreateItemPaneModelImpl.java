package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.models.observers.CreateItemPaneModelObserver;
import devopsdistilled.operp.client.items.panes.models.CreateItemPaneModel;

public class CreateItemPaneModelImpl extends
		AbstractPaneModel<CreateItemPaneModelObserver> implements
		CreateItemPaneModel {

	public CreateItemPaneModelImpl() {
		title = "Create Item";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
