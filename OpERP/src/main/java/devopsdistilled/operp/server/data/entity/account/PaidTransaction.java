package devopsdistilled.operp.server.data.entity.account;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PaidTransaction extends Transaction {

	private static final long serialVersionUID = -9114024897518324528L;

	@ManyToOne
	private PayableAccount account;

	public PayableAccount getAccount() {
		return account;
	}

	public void setAccount(PayableAccount account) {
		this.account = account;
	}

}
