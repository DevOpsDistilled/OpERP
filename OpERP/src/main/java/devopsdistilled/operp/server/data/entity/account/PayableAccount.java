package devopsdistilled.operp.server.data.entity.account;

import javax.persistence.Entity;

@Entity
public class PayableAccount extends Account<PaidTransaction> {

	private static final long serialVersionUID = 3505195542194191807L;

}
