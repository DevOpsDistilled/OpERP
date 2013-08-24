package devopsdistilled.operp.client.account.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.account.controllers.PaidTransactionController;
import devopsdistilled.operp.client.account.models.PaidTransactionModel;
import devopsdistilled.operp.client.account.panes.controllers.PaidTransactionPaneController;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;

public class PaidTransactionControllerImpl implements PaidTransactionController {

	@Inject
	private PaidTransactionPaneController paidTransactionPaneController;

	@Inject
	private PaidTransactionModel paidTransactionModel;

	@Override
	public void create() {
		paidTransactionPaneController.init(new PaidTransaction(),
				EntityOperation.Create);
	}

	@Override
	public void edit(PaidTransaction paidTransaction) {
		paidTransactionPaneController.init(paidTransaction,
				EntityOperation.Edit);
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PaidTransaction paidTransaction) {
		paidTransactionModel.deleteAndUpdateModel(paidTransaction);
	}

	@Override
	public void showDetails(PaidTransaction paidTransaction) {
		paidTransactionPaneController.init(paidTransaction,
				EntityOperation.Details);
	}

}
