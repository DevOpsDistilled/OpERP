package devopsdistilled.operp.client.stock.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.observers.TransferStockPaneModelObserver;

public class TransferStockPaneModelImpl extends
		AbstractPaneModel<TransferStockPaneModelObserver> implements
		TransferStockPaneModel {

	@Override
	public String getTitle() {
		return "Transfer Stock";
	}

}
