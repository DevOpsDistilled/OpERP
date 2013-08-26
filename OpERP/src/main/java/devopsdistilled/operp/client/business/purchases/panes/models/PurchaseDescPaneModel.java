package devopsdistilled.operp.client.business.purchases.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDescPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public interface PurchaseDescPaneModel extends
		EntityPaneModel<PurchaseDesc, PurchaseDescPaneModelObserver> {

	PurchaseDescRow getPurchaseDescRow();

	void setPurchaseDescRow(PurchaseDescRow purchaseDescRow);
}
