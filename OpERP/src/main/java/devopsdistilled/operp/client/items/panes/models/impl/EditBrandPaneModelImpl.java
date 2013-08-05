package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditBrandPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;

public class EditBrandPaneModelImpl extends
		AbstractEditEntityPaneModel<Brand, EditBrandPaneModelObserver>
		implements EditBrandPaneModel {

	@Override
	public String getTitle() {
		return "Edit Brand";
	}

}
