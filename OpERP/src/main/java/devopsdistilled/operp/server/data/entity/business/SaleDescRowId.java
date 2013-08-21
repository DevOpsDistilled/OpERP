package devopsdistilled.operp.server.data.entity.business;

import devopsdistilled.operp.server.data.entity.items.Item;

public class SaleDescRowId extends BusinessDescRowId<SaleDesc> {

	private static final long serialVersionUID = 7142133623544217869L;

	public SaleDescRowId() {
		super();
	}

	public SaleDescRowId(SaleDesc businessDesc, Item item) {
		super(businessDesc, item);
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof BusinessDescRowId)
				&& businessDesc.equals(((BusinessDescRowId<?>) o)
						.getBusinessDesc()) && item == ((BusinessDescRowId<?>) o)
					.getItem());
	}

	@Override
	public int hashCode() {
		return businessDesc.hashCode() + item.hashCode();
	}
}
