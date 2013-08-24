package devopsdistilled.operp.client.account.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.account.panes.ReceivedTransactionPane;
import devopsdistilled.operp.client.account.panes.models.ReceivedTransactionPaneModel;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public interface ReceivedTransactionPaneController
		extends
		EntityPaneController<ReceivedTransaction, ReceivedTransactionPaneModel, ReceivedTransactionPane> {

}
