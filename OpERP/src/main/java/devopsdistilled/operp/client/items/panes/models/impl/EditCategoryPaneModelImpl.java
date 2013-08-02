package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditCategoryPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public class EditCategoryPaneModelImpl extends
		AbstractEditEntityPaneModel<Category, EditCategoryPaneModelObserver>
		implements EditCategoryPaneModel {

	@Override
	public String getTitle() {
		return "Edit Category";
	}

}
