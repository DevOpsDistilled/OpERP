package devopsdistilled.operp.client.business.sales.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.business.sales.panes.SaleDescPane;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescPaneModel;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;

public interface SaleDescPaneController extends
		EntityPaneController<SaleDesc, SaleDescPaneModel, SaleDescPane> {

	void addNewSaleDescRow();

	void initEditSaleDescRow(SaleDescRow saleDescRow);

}
