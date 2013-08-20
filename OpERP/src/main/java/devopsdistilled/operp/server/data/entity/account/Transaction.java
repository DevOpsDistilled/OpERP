package devopsdistilled.operp.server.data.entity.account;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import devopsdistilled.operp.server.data.entity.Entiti;

@MappedSuperclass
public class Transaction<A extends Account<?>> extends Entiti<Long> {

	private static final long serialVersionUID = -6337337081648140247L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;

	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	private Double amount = 0.0;

	@ManyToOne
	protected A account;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public A getAccount() {
		return account;
	}

	public void setAccount(A account) {
		this.account = account;
	}

	@Override
	public Long id() {
		return getTransactionId();
	}

	@Override
	public String toString() {
		return new String(getTransactionId() + ": " + getTransactionDate()
				+ ": " + getAmount().toString());
	}

}
