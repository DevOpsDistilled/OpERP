package devopsdistilled.operp.server.data.entity.account;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ReceivableAccount extends Account {

	private static final long serialVersionUID = 6812190478232748288L;

	@OneToMany(mappedBy = "account")
	private List<ReceivedTransaction> transactions;

	public List<ReceivedTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<ReceivedTransaction> transactions) {
		this.transactions = transactions;
	}

}
