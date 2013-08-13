package devopsdistilled.operp.client.stock.panes.details;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.stock.controllers.StockKeeperController;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class StockKeepingDetailsPane extends
		AbstractEntityDetailsPane<StockKeeper, StockKeeperController> {

	@Inject
	private StockKeeperController stockKeeperController;

	private StockKeeper stockKeeper;

	private final JPanel pane;
	private final JTextField stockKeeperIdField;
	private final JTextField warehouseField;
	private final JTextField itemField;
	private final JTextField quantityField;
	private final JTextField dateField;
	private final JTextField stockWarehouseField;
	private final JTextField stockItemField;
	private final JTextField stockQuantityField;

	public StockKeepingDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][69.00]"));

		JLabel lblStockKeepingId = new JLabel("Stock Keeping ID");
		pane.add(lblStockKeepingId, "cell 0 0,alignx trailing");

		stockKeeperIdField = new JTextField();
		stockKeeperIdField.setEditable(false);
		pane.add(stockKeeperIdField, "cell 1 0,growx");
		stockKeeperIdField.setColumns(10);

		JLabel lblWarehouse = new JLabel("Warehouse");
		pane.add(lblWarehouse, "cell 0 1,alignx trailing");

		warehouseField = new JTextField();
		warehouseField.setEditable(false);
		pane.add(warehouseField, "cell 1 1,growx");
		warehouseField.setColumns(10);

		JLabel lblItem = new JLabel("Item");
		pane.add(lblItem, "cell 0 2,alignx trailing");

		itemField = new JTextField();
		itemField.setEditable(false);
		pane.add(itemField, "cell 1 2,growx");
		itemField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity Change");
		pane.add(lblQuantity, "cell 0 3,alignx trailing");

		quantityField = new JTextField();
		quantityField.setEditable(false);
		pane.add(quantityField, "cell 1 3,growx");
		quantityField.setColumns(10);

		JLabel lblDate = new JLabel("Date");
		pane.add(lblDate, "cell 0 4,alignx trailing");

		dateField = new JTextField();
		dateField.setEditable(false);
		pane.add(dateField, "cell 1 4,growx");
		dateField.setColumns(10);

		JPanel stockPanel = new JPanel();
		pane.add(stockPanel, "cell 1 6,growx,aligny top");
		stockPanel.setLayout(new MigLayout("", "[72.00][grow]", "[][][][]"));

		JLabel lblUpdatedStockSummary = new JLabel("Updated Stock Summary");
		stockPanel.add(lblUpdatedStockSummary, "cell 1 0");

		JLabel lblWarehouse_1 = new JLabel("Warehouse");
		stockPanel.add(lblWarehouse_1, "cell 0 1,alignx trailing");

		stockWarehouseField = new JTextField();
		stockWarehouseField.setEditable(false);
		stockPanel.add(stockWarehouseField, "cell 1 1,growx");
		stockWarehouseField.setColumns(10);

		JLabel lblItem_1 = new JLabel("Item");
		stockPanel.add(lblItem_1, "cell 0 2,alignx trailing");

		stockItemField = new JTextField();
		stockItemField.setEditable(false);
		stockPanel.add(stockItemField, "cell 1 2,growx");
		stockItemField.setColumns(10);

		JLabel lblQuantity_1 = new JLabel("Quantity");
		stockPanel.add(lblQuantity_1, "cell 0 3,alignx trailing");

		stockQuantityField = new JTextField();
		stockQuantityField.setEditable(false);
		stockPanel.add(stockQuantityField, "cell 1 3,growx");
		stockQuantityField.setColumns(10);
	}

	@Override
	public StockKeeperController getEntityController() {
		return stockKeeperController;
	}

	@Override
	protected StockKeeper getEntity() {
		return stockKeeper;
	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	public void init(StockKeeper stockKeeper) {
		this.stockKeeper = stockKeeper;
		if (stockKeeper != null) {
			stockKeeperIdField.setText(stockKeeper.getStockKeeperId()
					.toString());
			warehouseField.setText(stockKeeper.getWarehouse().toString());
			itemField.setText(stockKeeper.getItem().toString());
			quantityField.setText(stockKeeper.getQuantity().toString());
			dateField.setText(stockKeeper.getStockUpdateDate().toString());

			Stock stock = stockKeeper.getStock();
			stockWarehouseField.setText(stock.getWarehouse().toString());
			stockItemField.setText(stock.getItem().toString());
			stockQuantityField.setText(stock.getQuantity().toString());

		} else {
			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "Null StockKeeper");
		}
	}

	@Override
	public void show(StockKeeper stockKeeper, JComponent owner) {
		init(stockKeeper);
		if (stockKeeper != null)
			showDetailsPane(getPane(), owner);
	}

	@Override
	public String getTitle() {
		return "Stock Keeping Details";
	}

}
