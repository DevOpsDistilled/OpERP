package devopsdistilled.operp.server.data.entity.account;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import devopsdistilled.operp.server.data.entity.Entiti;

@MappedSuperclass
public abstract class Account extends Entiti<Long> {

	private static final long serialVersionUID = -8130237994739975187L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

	private Double balance;

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

	@Override
	public Long id() {
		return getAccountId();
	}

	@Override
	public String toString() {
		return new String(getAccountId() + ": " + getBalance().toString());
	}
}
