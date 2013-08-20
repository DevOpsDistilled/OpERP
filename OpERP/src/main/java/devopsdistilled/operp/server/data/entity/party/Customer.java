package devopsdistilled.operp.server.data.entity.party;

import javax.persistence.Entity;

import devopsdistilled.operp.server.data.entity.account.Receivable;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;

@Entity
public class Customer extends Party<ReceivableAccount> implements Receivable {

	private static final long serialVersionUID = 1504040341006393665L;

}
