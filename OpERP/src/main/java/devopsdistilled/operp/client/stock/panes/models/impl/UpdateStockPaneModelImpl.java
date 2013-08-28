package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.UpdateStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class UpdateStockPaneModelImpl extends
		AbstractPaneModel<UpdateStockPaneModelObserver> implements
		UpdateStockPaneModel {

	private Item item;
	private Warehouse warehouse;
	private Long quantity;
	private String note;

	@Override
	public String getNote() {
		return note;
	}

	@Override
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public Warehouse getWarehouse() {
		return warehouse;
	}

	@Override
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public Long getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String getTitle() {
		return "Update Stock";
	}

}
