package devopsdistilled.operp.client.account.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public interface ReceivedTransactionModelObserver extends EntityModelObserver {

	public void updateReceivedTransactions(
			List<ReceivedTransaction> receivedTransactions);

}
