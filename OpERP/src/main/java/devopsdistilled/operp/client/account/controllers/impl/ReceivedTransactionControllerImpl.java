package devopsdistilled.operp.client.account.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.account.controllers.ReceivedTransactionController;
import devopsdistilled.operp.client.account.models.ReceivedTransactionModel;
import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public class ReceivedTransactionControllerImpl implements
		ReceivedTransactionController {

	@Inject
	private ReceivedTransactionPaneController receivedTransactionPaneController;

	@Inject
	private ReceivedTransactionModel receivedTransactionModel;

	@Override
	public void create() {
		receivedTransactionPaneController.init(new ReceivedTransaction(),
				EntityOperation.Create);
	}

	@Override
	public void edit(ReceivedTransaction receivedTransaction) {
		receivedTransactionPaneController.init(receivedTransaction,
				EntityOperation.Edit);
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ReceivedTransaction receivedTransaction) {
		receivedTransactionModel.deleteAndUpdateModel(receivedTransaction);
	}

	@Override
	public void showDetails(ReceivedTransaction receivedTransaction) {
		receivedTransactionPaneController.init(receivedTransaction,
				EntityOperation.Details);
	}

}
