package devopsdistilled.operp.client.stock;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.controllers.StockKeeperController;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;

public class StockMgmtPane extends TaskPane {

	@Inject
	private StockKeeperController stockKeeperController;

	@Inject
	private StockController stockController;

	@Inject
	private WarehouseController warehouseController;

	private JButton btnListStock;
	private JButton btnCreateStock;
	private JButton btnCreateWarehouse;
	private JButton btnListWarehouse;
	private JButton btnTransferStock;
	
	private ImageIcon iconCreateStock;
	private ImageIcon iconListStock;
	private ImageIcon iconCreateWarehouse;
	private ImageIcon iconListWarehouse;
	private JButton btnListStock_1;
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
		pane.setLayout(new MigLayout("debug", "[]50[]", "[][]25[]25[][]"));

		JLabel lblStockManagement = new JLabel("Stock Management");
		lblStockManagement.setFont(new Font("Dialog", Font.BOLD, 16));
		pane.add(lblStockManagement, "cell 0 0 2 1,alignx center");

		btnCreateStock = new JButton("<html>Update<br/>Stock</html>");
		btnCreateStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockKeeperController.create();
			}

		});
		iconCreateStock=new ImageIcon(StockMgmtPane.class.
					getResource("/client/icons/Accounting.png"));
		btnCreateStock.setIcon(SetSizeForImage(iconCreateStock));
		pane.add(SetButtonSize(btnCreateStock), "flowx,cell 0 1");
		
		btnListStock = new JButton("<html>List<br/> Stock</html>");
		btnListStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockController.list();
			}
		});
		iconListStock= new ImageIcon(StockMgmtPane.class.
					getResource("/client/icons/Accounting.png"));
		btnListStock.setIcon(SetSizeForImage(iconListStock));
		pane.add(SetButtonSize(btnListStock), "cell 1 1");

		btnCreateWarehouse = new JButton("<html>Create<br/>Warehouse</html>");
		btnCreateWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				warehouseController.create();
			}
			
		});
		iconCreateWarehouse=new ImageIcon(StockMgmtPane.class.
					getResource("/client/icons/Accounting.png"));
		btnCreateWarehouse.setIcon(SetSizeForImage(iconCreateWarehouse));
		pane.add(SetButtonSize(btnCreateWarehouse), "flowx,cell 0 2");

		btnListWarehouse = new JButton("<html>List<br/>Warehouse<html>");
		btnListWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				warehouseController.list();
			}
		});
		iconListWarehouse=new ImageIcon(StockMgmtPane.class.
				getResource("/client/icons/Accounting.png"));
		btnListWarehouse.setIcon(SetSizeForImage(iconListWarehouse));
		pane.add(SetButtonSize(btnListWarehouse), "cell 1 2");
		
		btnTransferStock = new JButton("<html>Transfer<br/>Stock<html>");
		btnTransferStock = new JButton("Transfer Stock");
		btnTransferStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockKeeperController.transfer();
			}
		});
		pane.add(btnTransferStock, "cell 0 4");

		btnListStock_1 = new JButton("List Stock Activites");
		btnListStock_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockKeeperController.list();
			}
		});

		pane.add(btnListStock_1, "cell 1 4");

		return pane;

	}

}
