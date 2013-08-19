package devopsdistilled.operp.server.data.entity.account;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

@Entity
@Inheritance
public class PayableAccount extends Account {

	private static final long serialVersionUID = 3505195542194191807L;

	@OneToMany(mappedBy = "account")
	private List<PaidTransaction> transactions;

	public List<PaidTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<PaidTransaction> transactions) {
		this.transactions = transactions;
	}
}
