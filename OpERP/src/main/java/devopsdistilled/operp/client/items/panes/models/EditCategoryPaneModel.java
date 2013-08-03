package devopsdistilled.operp.client.items.panes.models;

import devopsdistilled.operp.client.abstracts.EditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditCategoryPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public interface EditCategoryPaneModel extends
		EditEntityPaneModel<Category, EditCategoryPaneModelObserver> {

}
