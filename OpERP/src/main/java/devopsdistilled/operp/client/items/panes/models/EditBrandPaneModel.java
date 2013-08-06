package devopsdistilled.operp.client.items.panes.models;

import devopsdistilled.operp.client.abstracts.EditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;

public interface EditBrandPaneModel extends
		EditEntityPaneModel<Brand, EditBrandPaneModelObserver> {

}
