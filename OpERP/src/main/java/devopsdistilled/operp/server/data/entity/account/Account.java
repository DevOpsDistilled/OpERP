package devopsdistilled.operp.server.data.entity.account;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import devopsdistilled.operp.server.data.entity.Entiti;

@MappedSuperclass
public abstract class Account<T extends Transaction<?>> extends Entiti<Long> {

	private static final long serialVersionUID = -8130237994739975187L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long accountId;

	protected Double balance = 0.0;

	@OneToMany(mappedBy = "account")
	protected List<T> transactions = new LinkedList<>();

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<T> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<T> transactions) {
		this.transactions = transactions;
	}

	@Override
	public Long id() {
		return getAccountId();
	}

	@Override
	public String toString() {
		return new String(getAccountId() + ": " + getBalance().toString());
	}
}
