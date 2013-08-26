package devopsdistilled.operp.client.stock.panes.models;

import devopsdistilled.operp.client.abstracts.EditEntityPaneModel;
import devopsdistilled.operp.client.stock.models.observers.EditStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public interface EditStockPaneModel extends 
	EditEntityPaneModel<Stock, EditStockPaneModelObserver>{

}
