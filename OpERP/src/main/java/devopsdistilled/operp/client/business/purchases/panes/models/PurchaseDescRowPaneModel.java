package devopsdistilled.operp.client.business.purchases.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDescRowPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public interface PurchaseDescRowPaneModel extends
		EntityPaneModel<PurchaseDescRow, PurchaseDescRowPaneModelObserver> {
}
