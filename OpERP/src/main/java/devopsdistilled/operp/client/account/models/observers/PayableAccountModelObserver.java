package devopsdistilled.operp.client.account.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.account.PayableAccount;

public interface PayableAccountModelObserver extends EntityModelObserver {

	public void updatePayableAccounts(List<PayableAccount> payableAccounts);

}
