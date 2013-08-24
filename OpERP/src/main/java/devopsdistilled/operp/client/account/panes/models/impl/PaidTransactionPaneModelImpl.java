package devopsdistilled.operp.client.account.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.account.panes.models.PaidTransactionPaneModel;
import devopsdistilled.operp.client.account.panes.models.observers.PaidTransactionPaneModelObserver;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;

public class PaidTransactionPaneModelImpl
		extends
		AbstractEntityPaneModel<PaidTransaction, PaidTransactionPaneModelObserver>
		implements PaidTransactionPaneModel {

	@Override
	public String getTitle() {
		return "Paid Transaction";
	}

}
