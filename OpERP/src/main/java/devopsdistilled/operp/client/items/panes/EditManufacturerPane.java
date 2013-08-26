package devopsdistilled.operp.client.items.panes;

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
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.items.panes.controllers.EditManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.details.ManufacturerDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.EditManufacturerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class EditManufacturerPane extends SubTaskPane implements
		EditManufacturerPaneModelObserver {

	@Inject
	private EditManufacturerPaneController controller;

	@Inject
	private ManufacturerDetailsPane manufacturerDetailsPane;

	private Manufacturer manufacturer;

	private final JPanel pane;
	private final JTextField manufacturerIdField;
	private final JTextField manufacturerNameField;
	
	public EditManufacturerPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblManufacturerId = new JLabel("Manufacturer ID");
		pane.add(lblManufacturerId, "cell 0 0,alignx trailing");

		manufacturerIdField = new JTextField();
		manufacturerIdField.setEditable(false);
		pane.add(manufacturerIdField, "cell 1 0,growx");
		manufacturerIdField.setColumns(10);

		JLabel lblManufacturerName = new JLabel("Manufacturer Name");
		pane.add(lblManufacturerName, "cell 0 1,alignx trailing");

		manufacturerNameField = new JTextField();
		pane.add(manufacturerNameField, "cell 1 1,growx");
		manufacturerNameField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 3");

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Long manufacturerId = manufacturer.getManufacturerId();
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setManufacturerId(manufacturerId);
				String manufacturerName = manufacturerNameField.getText()
						.trim();
				manufacturer.setManufacturerName(manufacturerName);

				try {
					controller.validate(manufacturer);
					manufacturer = controller.save(manufacturer);

					getDialog().dispose();
					manufacturerDetailsPane.show(manufacturer, getPane());

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}

			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEntity(manufacturer);
			}
		});
		pane.add(btnReset, "cell 1 3");
		pane.add(btnUpdate, "cell 1 3");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
		manufacturerIdField
				.setText(manufacturer.getManufacturerId().toString());
		manufacturerNameField.setText(manufacturer.getManufacturerName());
	}

}
