package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateProductPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.CreateProductPaneModelObserver;

public class CreateProductPaneModelImpl extends
		AbstractPaneModel<CreateProductPaneModelObserver> implements
		CreateProductPaneModel {

	@Override
	public String getTitle() {
		return "Create Product";
	}

}
