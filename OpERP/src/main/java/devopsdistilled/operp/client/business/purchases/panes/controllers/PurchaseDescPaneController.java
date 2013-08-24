package devopsdistilled.operp.client.business.purchases.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDescPane;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDescPaneModel;
import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public interface PurchaseDescPaneController extends
		EntityPaneController<PurchaseDesc, PurchaseDescPaneModel, PurchaseDescPane> {

	void addNewPurchaseDescRow();

	void initEditPurchaseDescRow(PurchaseDescRow purchaseDescRow);

}
