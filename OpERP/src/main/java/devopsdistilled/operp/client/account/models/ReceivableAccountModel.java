package devopsdistilled.operp.client.account.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.account.models.observers.ReceivableAccountModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;
import devopsdistilled.operp.server.data.service.account.ReceivableAccountService;

public interface ReceivableAccountModel
		extends
		EntityModel<ReceivableAccount, ReceivableAccountService, ReceivableAccountModelObserver> {

}
