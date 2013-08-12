package devopsdistilled.operp.client.stock.panes.models.impl;

import java.util.List;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.TransferStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class TransferStockPaneModelImpl extends
		AbstractPaneModel<TransferStockPaneModelObserver> implements
		TransferStockPaneModel {

	@Inject
	private StockModel stockModel;

	private List<Item> fromWarehouseItems;

	private Warehouse fromWarehouse;

	private Item itemToTransfer;

	private Warehouse toWarehouse;

	private Long quantity;

	@Override
	public String getTitle() {
		return "Transfer Stock";
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
	public Warehouse getFromWarehouse() {
		return fromWarehouse;
	}

	@Override
	public Item getItemToTransfer() {
		return itemToTransfer;
	}

	@Override
	public Warehouse getToWarehouse() {
		return toWarehouse;
	}

	@Override
	public void setFromWarehouse(Warehouse fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
		fromWarehouseItems = stockModel.getService().getItemsInWarehouse(
				fromWarehouse.getWarehouseId());
		for (TransferStockPaneModelObserver observer : observers) {
			observer.updateItems(fromWarehouseItems);
		}
	}

	@Override
	public void setItemToTransfer(Item itemtoTransfer) {
		this.itemToTransfer = itemtoTransfer;
	}

	@Override
	public void setToWarehouse(Warehouse toWarehouse) {
		this.toWarehouse = toWarehouse;
	}

}
