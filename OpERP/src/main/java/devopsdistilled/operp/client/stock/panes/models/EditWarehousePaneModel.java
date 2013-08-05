package devopsdistilled.operp.client.stock.panes.models;

import devopsdistilled.operp.client.abstracts.EditEntityPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.EditWarehousePaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public interface EditWarehousePaneModel extends 
		EditEntityPaneModel<Warehouse, EditWarehousePaneModelObserver>{

}
