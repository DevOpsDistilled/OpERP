package devopsdistilled.operp.client.stock;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StockMgmtPane extends TaskPane{

	@Inject
	private StockController stockController;
	
	@Inject
	private WarehouseController warehouseController;
	
	@Override
	public String toString() {
		return new String("Stock Management");
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	
	@Override
	public JComponent getPane() {
		JPanel pane=new JPanel();
		pane.setLayout(new MigLayout("", "[grow]", "[][][][]"));
		
		JLabel lblStockManagement = new JLabel("Stock Management");
		lblStockManagement.setFont(new Font("Dialog", Font.BOLD, 16));
		pane.add(lblStockManagement, "cell 0 0,alignx center");
		
		JButton btnUpdateStock=new JButton("Update Stock");
		btnUpdateStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockController.updateStock();
				
			}
			
		});
		pane.add(btnUpdateStock,"flowx,cell 0 1");
		
		JButton btnCreateWarehouse = new JButton("Create Warehouse");
		btnCreateWarehouse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				warehouseController.create();
			}
		});
			
		
		pane.add(btnCreateWarehouse, "cell 0 2");
		
		JButton btnListWarehouse = new JButton("List Warehouse");
		btnListWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			warehouseController.list();
			}
		});
		pane.add(btnListWarehouse, "cell 0 3");
		
		
		
		return pane;
	}

}
