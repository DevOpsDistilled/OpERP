package devopsdistilled.operp.client.business.purchases.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchasePaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public interface PurchasePaneModel extends
		EntityPaneModel<Purchase, PurchasePaneModelObserver> {

}
