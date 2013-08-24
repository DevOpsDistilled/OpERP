package devopsdistilled.operp.client.account.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.account.models.observers.PaidTransactionModelObserver;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;
import devopsdistilled.operp.server.data.service.account.PaidTransactionService;

public interface PaidTransactionModel
		extends
		EntityModel<PaidTransaction, PaidTransactionService, PaidTransactionModelObserver> {

}
