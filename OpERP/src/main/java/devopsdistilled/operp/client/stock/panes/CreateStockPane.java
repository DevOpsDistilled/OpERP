package devopsdistilled.operp.client.stock.panes;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.client.stock.panes.controllers.CreateStockPaneController;
import devopsdistilled.operp.client.stock.panes.details.StockDetailsPane;
import devopsdistilled.operp.client.stock.panes.models.observers.CreateStockPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class CreateStockPane extends SubTaskPane implements
		CreateStockPaneModelObserver, ItemModelObserver, WarehouseModelObserver{
	
	@Inject
	private CreateStockPaneController controller;
	
	@Inject
	private StockDetailsPane stockDetailsPane;
	
	@Inject
	private WarehouseController warehouseController;
	
	@Inject
	private ItemController itemController;
	
	
	private final JPanel pane;
	private final JTextField quantityField;
	private final JComboBox<Item>  comboItems;
	private final JComboBox<Warehouse>  comboWarehouses;
	
	
	@Override
	public void init(){
		super.init();
		
		// Other JDialog properties goes here
				// getDialog.setSize(...);
	}
	
	public CreateStockPane(){
		pane=new JPanel();
		pane.setLayout(new MigLayout("", "[]25[grow]", "[][][][][]"));
		
		JLabel lblItemName = new JLabel("Item Name");
		pane.add(lblItemName, "cell 0 0,alignx trailing");
		
		comboItems = new JComboBox<Item>();
		comboItems.setSelectedItem(null);
		pane.add(comboItems, "flowx,split 2,cell 1 0,growx");
		
		JButton btnNewItem = new JButton("New Item");
		btnNewItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				itemController.create();
			}
		});
		pane.add(btnNewItem, "cell 1 0");
		
		
		JLabel lblWarehouseName = new JLabel("Warehouse Name");
		pane.add(lblWarehouseName, "cell 0 1,alignx trailing");
		
		comboWarehouses = new JComboBox<Warehouse>();
		comboWarehouses.setSelectedItem(null);
		pane.add(comboWarehouses, "flowx,split 2,cell 1 1,growx");
		
		JButton btnNewWarehouse = new JButton("New Warehouse");
		btnNewWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				warehouseController.create();
			}
		});
		
		pane.add(btnNewWarehouse, "cell 1 1");
		
		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 2,alignx trailing");
		
		quantityField = new JTextField();
		pane.add(quantityField, "cell 1 2,growx");
		quantityField.setColumns(15);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,split 3,cell 1 4");
		
		JButton btnUpdate = new JButton("Create");
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Stock stock=new Stock();
				Item item=(Item)comboItems.getSelectedItem();
				stock.setItem(item);
				Warehouse warehouse=(Warehouse)comboWarehouses.getSelectedItem();
				stock.setWarehouse(warehouse);
				String itemquantity=quantityField.getText().trim();
				
				try{
					Long quantity=Long.parseLong(itemquantity);
					stock.setQuantity(quantity);
					try{
						controller.validate(stock);
						stock=controller.save(stock);
						getDialog().dispose();
						stockDetailsPane.show(stock);
						
					}catch(NullFieldException ex){
						JOptionPane.showMessageDialog(getPane(), "Required Fields are Null");
					}
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getPane(),
							"Quantity must be a Numeric value");
				}
				
			}
		});
		pane.add(btnUpdate, "cell 1 4");
			
		
}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateItems(List<Item> items) {
		//TODo
	}
	
	@Override
	public void updateWarehouse(List<Warehouse> warehouses) {
		Warehouse prevSelected = (Warehouse) comboWarehouses.getSelectedItem();
		comboWarehouses.removeAllItems();
		for (Warehouse warehouse :warehouses)	{
			comboWarehouses.addItem(warehouse);
		}
		if (warehouses.contains(prevSelected))
			comboWarehouses.setSelectedItem(prevSelected);
		else
			comboWarehouses.setSelectedItem(null);
	}
}
	
	
