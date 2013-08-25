package devopsdistilled.operp.client.business.purchases.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchasePaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchasePaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public class PurchasePaneModelImpl extends
		AbstractEntityPaneModel<Purchase, PurchasePaneModelObserver> implements
		PurchasePaneModel {

	@Override
	public String getTitle() {
		return "Purchase";
	}

}
