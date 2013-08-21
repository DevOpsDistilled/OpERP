package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.Entity;
import javax.persistence.IdClass;

@Entity
@IdClass(SaleDescRowId.class)
public class SaleDescRow extends BusinessDescRow<SaleDesc> {

	private static final long serialVersionUID = 8479701082376399518L;

}
