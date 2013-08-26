package devopsdistilled.operp.client.business.purchases.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDescRowPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDescRowPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public class PurchaseDescRowPaneModelImpl extends
		AbstractEntityPaneModel<PurchaseDescRow, PurchaseDescRowPaneModelObserver>
		implements PurchaseDescRowPaneModel {

	@Override
	public String getTitle() {
		return "Purchase Description Row";
	}

}
