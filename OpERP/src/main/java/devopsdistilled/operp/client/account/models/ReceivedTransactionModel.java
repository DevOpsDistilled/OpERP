package devopsdistilled.operp.client.account.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.account.models.observers.ReceivedTransactionModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;
import devopsdistilled.operp.server.data.service.account.ReceivedTransactionService;

public interface ReceivedTransactionModel
		extends
		EntityModel<ReceivedTransaction, ReceivedTransactionService, ReceivedTransactionModelObserver> {

}
