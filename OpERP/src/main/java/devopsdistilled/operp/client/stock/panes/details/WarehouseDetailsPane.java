package devopsdistilled.operp.client.stock.panes.details;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class WarehouseDetailsPane extends
		AbstractEntityDetailsPane<Warehouse>{
	
	@Inject
	private WarehouseController warehouseController;
	
	private Warehouse warehouse;

	private JPanel pane;
	private JTextField warehouseIdField;
	private JTextField warehouseNameField;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnOk;
	
	
	public WarehouseDetailsPane(){
		dialog.setTitle("Warehouse Details");
		pane=new JPanel();
		getDialog().getContentPane().add(getPane());
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblWarehouseId = new JLabel("Warehouse Id");
		pane.add(lblWarehouseId, "cell 0 0,alignx trailing");
		
		warehouseIdField = new JTextField();
		warehouseIdField.setColumns(10);
		warehouseIdField.setEditable(false);
		pane.add(warehouseIdField, "cell 1 0,growx");
		
		
		JLabel lblWarehouseName = new JLabel("Warehouse Name");
		pane.add(lblWarehouseName, "cell 0 1,alignx trailing");
		
		warehouseNameField = new JTextField();
		pane.add(warehouseNameField, "cell 1 1,growx");
		warehouseNameField.setEditable(false);
		warehouseNameField.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				warehouseController.delete(warehouse);
			}
		});
		pane.add(btnDelete, "flowx,cell 1 3");
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getDialog().dispose();
				warehouseController.edit(warehouse);
			}
		});
		pane.add(btnEdit, "cell 1 3");
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnOk, "cell 1 3");
		
	}
	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void show(Warehouse warehouse) {
		this.warehouse=warehouse;
		if(warehouse!=null){
			warehouseIdField.setText(warehouse.getWarehouseId().toString());
			warehouseNameField.setText(warehouse.getWarehouseName());
			getDialog().setVisible(true);
		}else {
			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "Null Warehouse");
		}
		
	}
	@Override
	public String getTitle() {
		return "Warehouse Details";
	}

}
