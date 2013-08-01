package devopsdistilled.operp.client.items.panes.models.observers;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateProductPaneModel;

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
