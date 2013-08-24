package devopsdistilled.operp.client.account.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.account.PaidTransaction;

public interface PaidTransactionModelObserver extends EntityModelObserver {

	public void updatePaidTransactions(List<PaidTransaction> paidTransactions);

}
