package devopsdistilled.operp.client.business.purchases.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDescPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchaseDescPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public class PurchaseDescPaneModelImpl extends
		AbstractEntityPaneModel<PurchaseDesc, PurchaseDescPaneModelObserver> implements
		PurchaseDescPaneModel {

	private PurchaseDescRow purchaseDescRow;

	@Override
	public String getTitle() {
		return "Purchase Description";
	}

	@Override
	public PurchaseDescRow getPurchaseDescRow() {
		return purchaseDescRow;
	}

	@Override
	public void setPurchaseDescRow(PurchaseDescRow purchaseDescRow) {
		this.purchaseDescRow = purchaseDescRow;
	}

}
