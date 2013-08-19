package devopsdistilled.operp.server.data.entity.account;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class PayableAccount extends Account {

	private static final long serialVersionUID = 3505195542194191807L;

}
