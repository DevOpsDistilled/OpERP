package devopsdistilled.operp.server.data.entity.party;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.account.Receivable;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;

@Entity
public class Customer extends Party implements Receivable {

	private static final long serialVersionUID = 1504040341006393665L;

	@OneToOne(cascade = CascadeType.ALL)
	private ReceivableAccount account;

	public ReceivableAccount getAccount() {
		return account;
	}

	public void setAccount(ReceivableAccount account) {
		this.account = account;
	}

}
