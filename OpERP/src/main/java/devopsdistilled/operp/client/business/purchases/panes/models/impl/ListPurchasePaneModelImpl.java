package devopsdistilled.operp.client.business.purchases.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.ListPurchasePaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.ListPurchasePaneModelObserver;

public class ListPurchasePaneModelImpl extends
		AbstractPaneModel<ListPurchasePaneModelObserver> implements
		ListPurchasePaneModel {

	@Override
	public String getTitle() {
		return "Purchase List";
	}

}
