package devopsdistilled.operp.server.data.entity.account;

import javax.persistence.Entity;

@Entity
public class PaidTransaction extends Transaction<PayableAccount> {

	private static final long serialVersionUID = -9114024897518324528L;

}
