package devopsdistilled.operp.client.account.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;

public interface ReceivableAccountModelObserver extends EntityModelObserver {

	public void updateReceivableAccounts(
			List<ReceivableAccount> receivableAccounts);

}
