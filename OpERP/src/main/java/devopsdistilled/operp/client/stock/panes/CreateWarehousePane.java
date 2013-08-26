package devopsdistilled.operp.client.stock.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.stock.panes.controllers.CreateWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.details.WarehouseDetailsPane;
import devopsdistilled.operp.client.stock.panes.models.observers.CreateWarehousePaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class CreateWarehousePane extends SubTaskPane implements
		CreateWarehousePaneModelObserver {

	@Inject
	private CreateWarehousePaneController controller;

	@Inject
	private WarehouseDetailsPane warehouseDetailsPane;
	private final JPanel pane;
	private final JTextField warehouseNameField;
	
	public CreateWarehousePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblWarehouseName = new JLabel("WareHouse Name");
		pane.add(lblWarehouseName, "cell 0 0,alignx trailing");

		warehouseNameField = new JTextField();
		pane.add(warehouseNameField, "cell 1 0,growx");
		warehouseNameField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 1");

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Warehouse warehouse = new Warehouse();
				String warehouseName = warehouseNameField.getText().trim();
				warehouse.setWarehouseName(warehouseName);
				try {
					controller.validate(warehouse);
					warehouse = controller.save(warehouse);
					getDialog().dispose();
					warehouseDetailsPane.show(warehouse, getPane());

				} catch (NullFieldException ex) {
					JOptionPane.showMessageDialog(getPane(),
							"Required field(s) are Null");
				} catch (EntityNameExistsException ex) {
					JOptionPane.showMessageDialog(getPane(),
							"Warehouse name already exists");
				}
			}
		});
		pane.add(btnCreate, "cell 1 1");
		

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
