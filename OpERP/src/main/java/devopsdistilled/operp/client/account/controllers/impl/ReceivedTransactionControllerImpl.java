package devopsdistilled.operp.client.account.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.account.controllers.ReceivedTransactionController;
import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public class ReceivedTransactionControllerImpl implements
		ReceivedTransactionController {

	@Inject
	private ReceivedTransactionPaneController receivedTransactionPaneController;

	@Override
	public void create() {
		receivedTransactionPaneController.init(new ReceivedTransaction(),
				EntityOperation.Create);
	}

	@Override
	public void edit(ReceivedTransaction receivedTransaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ReceivedTransaction receivedTransaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDetails(ReceivedTransaction receivedTransaction) {
		// TODO Auto-generated method stub

	}

}
