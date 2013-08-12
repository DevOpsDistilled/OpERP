package devopsdistilled.operp.client.items.panes.models;

import devopsdistilled.operp.client.abstracts.EditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditProductPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Product;

public interface EditProductPaneModel extends
		EditEntityPaneModel<Product, EditProductPaneModelObserver> {

}
