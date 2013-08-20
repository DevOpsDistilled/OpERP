package devopsdistilled.operp.server.data.service.account;

import devopsdistilled.operp.server.data.entity.account.Account;
import devopsdistilled.operp.server.data.service.EntityService;

public interface AccountService<A extends Account<?>> extends
		EntityService<A, Long> {

}
