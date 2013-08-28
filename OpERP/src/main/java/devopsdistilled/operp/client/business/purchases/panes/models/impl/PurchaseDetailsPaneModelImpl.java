package devopsdistilled.operp.client.business.purchases.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDetailsPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDetailsPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;

public class PurchaseDetailsPaneModelImpl extends
		AbstractEntityPaneModel<Purchase, PurchaseDetailsPaneModelObserver>
		implements PurchaseDetailsPaneModel {

	@Override
	public String getTitle() {
		return "Purchase Summary";
	}

}
