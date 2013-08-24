package devopsdistilled.operp.server.data.service.account;

import devopsdistilled.operp.server.data.entity.account.Transaction;
import devopsdistilled.operp.server.data.service.EntityService;

public interface TransactionService<T extends Transaction<?>> extends
		EntityService<T, Long> {

}
