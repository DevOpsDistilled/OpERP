package devopsdistilled.operp.client.business.sales.panes.controllers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.business.sales.panes.SaleDescRowPane;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescRowPaneModel;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public interface SaleDescRowPaneController
		extends
		EntityPaneController<SaleDescRow, SaleDescRowPaneModel, SaleDescRowPane> {

	List<Item> getItemsInWarehouse(Warehouse selWarehouse);

	Long getQuantityOfItem(Item selItem);

}
