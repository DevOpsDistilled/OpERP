package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.CreateCategoryPaneModelObserver;

public class CreateCategoryPaneModelImpl extends
		AbstractPaneModel<CreateCategoryPaneModelObserver> implements
		CreateCategoryPaneModel {

	public CreateCategoryPaneModelImpl() {
		title = "Create Category";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
