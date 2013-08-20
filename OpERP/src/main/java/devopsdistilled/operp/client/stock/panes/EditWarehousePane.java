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
import devopsdistilled.operp.client.stock.panes.controllers.EditWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.details.WarehouseDetailsPane;
import devopsdistilled.operp.client.stock.panes.models.observers.EditWarehousePaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class EditWarehousePane extends SubTaskPane implements
		EditWarehousePaneModelObserver {

	@Inject
	private EditWarehousePaneController controller;

	@Inject
	private WarehouseDetailsPane warehouseDetailsPane;

	private final JPanel pane;
	private final JTextField warehouseIdField;
	private final JTextField warehouseNameField;
	private final JButton btnCancel;
	private final JButton btnUpdate;
	private JButton btnReset;
	private Warehouse warehouse;

	public EditWarehousePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblWarehouseId = new JLabel("Warehouse Id");
		pane.add(lblWarehouseId, "cell 0 0,alignx trailing");

		warehouseIdField = new JTextField();
		warehouseIdField.setEditable(false);
		pane.add(warehouseIdField, "cell 1 0,growx");
		warehouseIdField.setColumns(10);

		JLabel lblWarehouseName = new JLabel("Warehouse Name");
		pane.add(lblWarehouseName, "cell 0 1,alignx trailing");

		warehouseNameField = new JTextField();
		pane.add(warehouseNameField, "cell 1 1,growx");
		warehouseNameField.setColumns(10);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});

		pane.add(btnCancel, "flowx,cell 1 3");

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Warehouse warehouse = new Warehouse();

				Long warehouseId = Long.parseLong(warehouseIdField.getText()
						.trim());
				warehouse.setWarehouseId(warehouseId);

				String warehouseName = warehouseNameField.getText().trim();
				warehouse.setWarehouseName(warehouseName);

				try {
					controller.validate(warehouse);
					warehouse = controller.save(warehouse);
					getDialog().dispose();
					warehouseDetailsPane.show(warehouse, getPane());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());

				}

			}
		});
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateEntity(warehouse);
			}
		});
		pane.add(btnReset, "cell 1 3");
		pane.add(btnUpdate, "cell 1 3");

	}

	@Override
	public void updateEntity(Warehouse warehouse) {
		this.warehouse=warehouse;
		warehouseIdField.setText(warehouse.getWarehouseId().toString());
		warehouseNameField.setText(warehouse.getWarehouseName());
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
