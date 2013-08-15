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
import devopsdistilled.operp.client.items.panes.controllers.CreateManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.details.ManufacturerDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.CreateManufacturerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class CreateManufacturerPane extends SubTaskPane implements
		CreateManufacturerPaneModelObserver {

	@Inject
	private CreateManufacturerPaneController controller;

	@Inject
	private ManufacturerDetailsPane manufacturerDetailsPane;

	private final JPanel pane;
	private final JTextField manufacturerNameField;
	
	public CreateManufacturerPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][]"));

		JLabel lblManufacturerName = new JLabel("Manufacturer Name");
		pane.add(lblManufacturerName, "cell 0 0,alignx trailing");

		manufacturerNameField = new JTextField();
		pane.add(manufacturerNameField, "cell 1 0,growx");
		manufacturerNameField.setColumns(10);

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
				Manufacturer manufacturer = new Manufacturer();
				String manufactuerName = manufacturerNameField.getText().trim();
				manufacturer.setManufacturerName(manufactuerName);

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
		pane.add(btnCreate, "cell 1 1");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
