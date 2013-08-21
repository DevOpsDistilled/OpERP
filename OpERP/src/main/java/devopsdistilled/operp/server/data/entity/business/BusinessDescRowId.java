package devopsdistilled.operp.server.data.entity.business;

import java.io.Serializable;

import devopsdistilled.operp.server.data.entity.items.Item;

public class BusinessDescRowId<BD extends BusinessDesc<?, ?>> implements
		Serializable {

	private static final long serialVersionUID = -881131459472534341L;

	protected BD businessDesc;

	protected Item item;

	public BusinessDescRowId() {

	}

	public BusinessDescRowId(BD businessDesc, Item item) {
		super();
		this.businessDesc = businessDesc;
		this.item = item;
	}

	public BD getBusinessDesc() {
		return businessDesc;
	}

	public void setBusinessDesc(BD businessDesc) {
		this.businessDesc = businessDesc;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
