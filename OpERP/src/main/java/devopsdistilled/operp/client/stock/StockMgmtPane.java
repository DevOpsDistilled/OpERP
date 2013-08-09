package devopsdistilled.operp.client.stock;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;

public class StockMgmtPane extends TaskPane {

	@Inject
	private StockController stockController;

	@Inject
	private WarehouseController warehouseController;

	private JButton btnListStock;
	private JButton btnCreateStock;
	private JButton btnCreateWarehouse;
	private JButton btnListWarehouse;
	private JButton btnTransferStock;

	@Override
	public String toString() {
		return new String("Stock Management");
	}

	/**
	 * @wbp.parser.entryPoint
	 */

	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]20[]", "[][][][][]"));

		JLabel lblStockManagement = new JLabel("Stock Management");
		lblStockManagement.setFont(new Font("Dialog", Font.BOLD, 16));
		pane.add(lblStockManagement, "cell 0 0 2 1,alignx center");

		btnCreateStock = new JButton("Update Stock");
		btnCreateStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockController.create();

			}

		});
		pane.add(btnCreateStock, "flowx,cell 0 1");

		btnCreateWarehouse = new JButton("Create Warehouse");
		btnCreateWarehouse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				warehouseController.create();
			}
		});

		btnListStock = new JButton("List Stock");
		btnListStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockController.list();
			}
		});

		pane.add(btnListStock, "cell 1 1");

		pane.add(btnCreateWarehouse, "flowx,cell 0 2");

		btnListWarehouse = new JButton("List Warehouse");
		btnListWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				warehouseController.list();
			}
		});
		pane.add(btnListWarehouse, "cell 1 2");
		
		btnTransferStock = new JButton("Transfer Stock");
		pane.add(btnTransferStock, "cell 0 4");

		return pane;

	}

}
