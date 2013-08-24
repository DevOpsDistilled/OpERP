package devopsdistilled.operp.client.account.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.account.panes.models.ReceivedTransactionPaneModel;
import devopsdistilled.operp.client.account.panes.models.observers.ReceivedTransactionPaneModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public class ReceivedTransactionPaneModelImpl
		extends
		AbstractEntityPaneModel<ReceivedTransaction, ReceivedTransactionPaneModelObserver>
		implements ReceivedTransactionPaneModel {

	@Override
	public String getTitle() {
		return "Received Transaction";
	}

}
