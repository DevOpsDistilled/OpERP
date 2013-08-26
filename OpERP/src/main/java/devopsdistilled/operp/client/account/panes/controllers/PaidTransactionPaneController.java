package devopsdistilled.operp.client.account.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.account.panes.PaidTransactionPane;
import devopsdistilled.operp.client.account.panes.models.PaidTransactionPaneModel;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;

public interface PaidTransactionPaneController
		extends
		EntityPaneController<PaidTransaction, PaidTransactionPaneModel, PaidTransactionPane> {

}
