package devopsdistilled.operp.client.account.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.account.panes.models.observers.PaidTransactionPaneModelObserver;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;

public interface PaidTransactionPaneModel extends
		EntityPaneModel<PaidTransaction, PaidTransactionPaneModelObserver> {

}
