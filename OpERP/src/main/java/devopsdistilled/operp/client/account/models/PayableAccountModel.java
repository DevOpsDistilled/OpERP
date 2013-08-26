package devopsdistilled.operp.client.account.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.account.models.observers.PayableAccountModelObserver;
import devopsdistilled.operp.server.data.entity.account.PayableAccount;
import devopsdistilled.operp.server.data.service.account.PayableAccountService;

public interface PayableAccountModel
		extends
		EntityModel<PayableAccount, PayableAccountService, PayableAccountModelObserver> {

}
