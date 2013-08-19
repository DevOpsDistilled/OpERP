package devopsdistilled.operp.server.data.entity.party;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.account.Payable;
import devopsdistilled.operp.server.data.entity.account.PayableAccount;

@Entity
public class Vendor extends Party implements Payable {

	private static final long serialVersionUID = 1438740246885453097L;

	@OneToOne
	private PayableAccount account;

	public PayableAccount getAccount() {
		return account;
	}

	public void setAccount(PayableAccount account) {
		this.account = account;
	}

}
