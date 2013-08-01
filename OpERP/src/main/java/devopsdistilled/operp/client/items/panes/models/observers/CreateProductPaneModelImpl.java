package devopsdistilled.operp.client.items.panes.model.observers;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.model.CreateProductPaneModel;

public class CreateProductPaneModelImpl extends
		AbstractPaneModel<CreateProductPaneModelObserver> implements
		CreateProductPaneModel {

	public CreateProductPaneModelImpl() {
		title = "Create Product";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
