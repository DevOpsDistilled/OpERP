package devopsdistilled.operp.server.data.entity.account;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ReceivedTransaction extends Transaction {

	private static final long serialVersionUID = -9082401297374506703L;

	@ManyToOne
	private ReceivableAccount account;

	public ReceivableAccount getAccount() {
		return account;
	}

	public void setAccount(ReceivableAccount account) {
		this.account = account;
	}
}
