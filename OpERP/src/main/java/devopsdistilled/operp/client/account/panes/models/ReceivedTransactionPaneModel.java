package devopsdistilled.operp.client.account.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.account.panes.models.observers.ReceivedTransactionPaneModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public interface ReceivedTransactionPaneModel
		extends
		EntityPaneModel<ReceivedTransaction, ReceivedTransactionPaneModelObserver> {

}
