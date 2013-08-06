package devopsdistilled.operp.client.stock.panes.details;

import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockDetailsPane extends 
	AbstractEntityDetailsPane<Stock,StockController>{
	
	@Inject
	private StockController stockController;
	
	private Stock stock;
	
	private JPanel pane;
	private JTextField stockIdField;
	private JLabel lblItem;
	private JTextField itemField;
	private JLabel lblWarehouse;
	private JTextField warehouseField;
	private JLabel lblQuantity;
	private JTextField quantityField;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnOk;
	
	public StockDetailsPane(){
		dialog.setTitle("Stock Details");
		pane=new JPanel(new MigLayout("debug", "[][grow]", "[][][][][][]"));
		getDialog().getContentPane().add(getPane());
		
		JLabel lblStockId = new JLabel("Stock Id");
		pane.add(lblStockId, "cell 0 0");
		
		stockIdField=new JTextField();
		stockIdField.setEditable(false);
		stockIdField.setColumns(10);
		pane.add(stockIdField,"cell 1 0,growx");
		
		lblItem = new JLabel("Item ");
		pane.add(lblItem, "cell 0 1,alignx trailing");
		
		itemField = new JTextField();
		itemField.setEditable(false);
		pane.add(itemField, "cell 1 1,growx");
		itemField.setColumns(10);
		
		lblWarehouse = new JLabel("warehouse");
		pane.add(lblWarehouse, "cell 0 2,alignx trailing");
		
		warehouseField = new JTextField();
		warehouseField.setEditable(false);
		pane.add(warehouseField, "cell 1 2,growx");
		warehouseField.setColumns(10);
		
		lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 3,alignx trailing");
		
		quantityField = new JTextField();
		quantityField.setEditable(false);
		pane.add(quantityField, "cell 1 3,growx");
		quantityField.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			getDialog().dispose();
			stockController.delete(stock);
			}
			
		});
		pane.add(btnDelete, "flowx,cell 1 5");
		
		btnEdit = new JButton("Edit");
		//TODO
		pane.add(btnEdit, "cell 1 5");
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnOk, "cell 1 5");
		
		
		
	}
	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Stock stock) {
		this.stock=stock;
		if(stock!=null){
			stockIdField.setText(stock.getStockId().toString());
			itemField.setText(stock.getItem().getItemName());
			warehouseField.setText(stock.getWarehouse().getWarehouseName());
			quantityField.setText(stock.getQuantity().toString());
			getDialog().setVisible(true);
		}else{
			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(),"Stock is null");
		}
	}

	@Override
	public String getTitle() {
		return "Stock Details";
	}
	@Override
	public StockController getEntityController() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Stock getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
