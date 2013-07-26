package devopsdistilled.operp.client.items.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.models.observers.CreateItemPaneModelObserver;

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
