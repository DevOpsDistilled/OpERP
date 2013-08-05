package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateBrandPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.CreateBrandPaneModelObserver;

public class CreateBrandPaneModelImpl extends
		AbstractPaneModel<CreateBrandPaneModelObserver> implements
		CreateBrandPaneModel {

	@Override
	public String getTitle() {
		return "Create Brand";
	}

}
