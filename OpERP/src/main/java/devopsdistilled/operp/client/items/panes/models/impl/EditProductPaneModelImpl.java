package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditProductPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditProductPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Product;

public class EditProductPaneModelImpl extends
		AbstractEditEntityPaneModel<Product, EditProductPaneModelObserver>
		implements EditProductPaneModel {

	@Override
	public String getTitle() {
		return "Edit Product";
	}

}
